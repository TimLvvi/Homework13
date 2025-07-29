package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm();

    String contentType();

    default String getStringRepresentation() {
        return searchTerm() + " — " + contentType();
    }
}
