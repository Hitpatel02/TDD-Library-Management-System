package com.example;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<String, Map<String, Object>> books = new HashMap<>();

    // Add a new book to the library
    public boolean addBook(Map<String, Object> book) {
        String isbn = (String) book.get("isbn");
        if (books.containsKey(isbn)) {
            return false; // Book with this ISBN already exists
        }
        books.put(isbn, book);
        return true;
    }
}
