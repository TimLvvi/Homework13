package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchQuery) {
        super("не нашлось подходящей статьи и продукта: " + searchQuery);
    }
}