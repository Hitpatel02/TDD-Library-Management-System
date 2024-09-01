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

    // Borrow a book from the library
    public boolean borrowBook(String isbn) {
        Map<String, Object> book = books.get(isbn);
        if (book == null) {
            return false; // Book that user wants to borrow is not found or book doesn't exist in library.
        }
        Boolean isBorrowed = (Boolean) book.getOrDefault("isBorrowed", false);
        if (!isBorrowed) {
            book.put("isBorrowed", true);
            return true;
        }
        return false; // Book is already borrowed
    }

    // Return a borrowed book to the library
    public boolean returnBook(String isbn) {
        Map<String, Object> book = books.get(isbn);
        if (book == null) {
            return false; // Did the book that a person wants to return previously exist in the library
        }
        Boolean isBorrowed = (Boolean) book.get("isBorrowed");
        if (isBorrowed != null && isBorrowed) {
            book.put("isBorrowed", false);
            return true;
        }
        return false; // Book was not borrowed that means it can't be returned
    }
}
