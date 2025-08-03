package org.skypro.skyshop.articlesProducts;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    public String articleTitle;
    public String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return "Название статьи:" + articleTitle + ". " +
                "Текст статьи:" + articleText;
    }

    @Override
    public String searchTerm() {
        return articleTitle;
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }
}
