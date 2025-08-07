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
        return Arrays.toString(searchables);
    }

    // метод возврата наиболее подходящего продукта (или статьи) по запросу
    public Searchable findBestResult(String search) throws BestResultNotFoundException {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFoundException(search);
        }
        Searchable bestResult = null;
        int maxSubstringFind = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int count = countSubstringOccurrences(searchable.searchTerm(), search);
                if (count > maxSubstringFind) {
                    maxSubstringFind = count;
                    bestResult = searchable;
                }
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFoundException(search);
        }
        return bestResult;
    }


    //метод нахождение количества повторов запроса
    private int countSubstringOccurrences(String str, String substring) {
        if (str == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int indexSubstring = str.indexOf(substring, index);

        while (indexSubstring != -1) {
            count++;
            index = indexSubstring + substring.length();
            indexSubstring = str.indexOf(substring, index);
        }

        return count;
    }
}





