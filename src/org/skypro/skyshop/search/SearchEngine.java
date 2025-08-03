package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    // Добавление элемента для поиска
    public void add(Searchable searchable) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex++] = searchable;
        }
    }

    // Поиск по запросу
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(query)) {
                results[foundCount++] = searchable;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }

    @Override
    public String toString() {
        return  Arrays.toString(searchables) ;
    }
}