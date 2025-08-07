package org.skypro.skyshop.search;

public class BestResultNotFoundException extends Exception {
    public BestResultNotFoundException(String searchQuery) {
        super("не нашлось подходящей статьи и продукта: " + searchQuery);
    }
}