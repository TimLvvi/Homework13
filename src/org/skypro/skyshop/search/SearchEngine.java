package org.skypro.skyshop.search;

import java.util.Arrays;
import java.util.LinkedList;

public class SearchEngine {
    private LinkedList<Searchable> searchables = new LinkedList<>();


    // Добавление элемента для поиска
    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    // Поиск по запросу
    public LinkedList<Searchable> search(String query) {
        LinkedList<Searchable> results = new LinkedList<>();


        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(query)) {
                results.add(searchable);

            }
        }

        return results;
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

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchables=" + searchables +
                '}';
    }
}





