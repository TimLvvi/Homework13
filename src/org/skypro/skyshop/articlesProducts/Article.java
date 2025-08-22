package org.skypro.skyshop.articlesProducts;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleTitle);
    }

    @Override
    public String contentType() {
        return "ARTICLE";



    }
}
