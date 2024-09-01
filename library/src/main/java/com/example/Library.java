package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class Library {

    // A map to store books, where the key is the ISBN and the value is the book's properties.
    private Map<String, Map<String, Object>> books = new HashMap<>();

    // Add a new book to the library.
    public boolean addBook(Map<String, Object> book) {
        String isbn = (String) book.get("isbn");
        if (books.containsKey(isbn)) {
            return false; // Book with this ISBN already exists in the library.
        }
        books.put(isbn, book); // Add the book to the library.
        return true;
    }

    // Borrow a book from the library.
    public boolean borrowBook(String isbn) {
        Map<String, Object> book = books.get(isbn);
        if (book == null) {
            return false; // The book does not exist in the library.
        }
        Boolean isBorrowed = (Boolean) book.getOrDefault("isBorrowed", false);
        if (!isBorrowed) {
            book.put("isBorrowed", true); // Mark the book as borrowed.
            return true;
        }
        return false; // The book is already borrowed.
    }

    // Return a borrowed book to the library.
    public boolean returnBook(String isbn) {
        Map<String, Object> book = books.get(isbn);
        if (book == null) {
            return false; // The book does not exist in the library.
        }
        Boolean isBorrowed = (Boolean) book.get("isBorrowed");
        if (isBorrowed != null && isBorrowed) {
            book.put("isBorrowed", false); // Mark the book as returned.
            return true;
        }
        return false; // The book was not borrowed.
    }

    // View all available books in the library (books that are not currently borrowed).
    public Collection<Map<String, Object>> viewAvailableBooks() {
        Map<String, Map<String, Object>> availableBooks = new HashMap<>();
        for (Map.Entry<String, Map<String, Object>> entry : books.entrySet()) {
            Boolean isBorrowed = (Boolean) entry.getValue().getOrDefault("isBorrowed", false);
            if (!isBorrowed) {
                availableBooks.put(entry.getKey(), entry.getValue()); // Add the book to the list of available books.
            }
        }
        return availableBooks.values();
    }
}
