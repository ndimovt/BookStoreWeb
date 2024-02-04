package io.github.ndimovt.bookstore.entity;

import java.util.Comparator;

public class AuthorSort implements Comparator<Book> {
    public int compare(Book first, Book second) {
        return first.getAuthorName().compareToIgnoreCase(second.getAuthorName());
    }
}
