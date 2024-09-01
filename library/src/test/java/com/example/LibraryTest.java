package com.example;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    private Map<String, Object> createBook(String isbn, String title, String author, int year) {
        Map<String, Object> book = new HashMap<>();
        book.put("isbn", isbn);
        book.put("title", title);
        book.put("author", author);
        book.put("publicationYear", year);
        return book;
    }

    @Test
    public void addBookTest() {
        Map<String, Object> book1 = createBook("978-0134685991", "Effective Java", "Joshua Bloch", 2018);

        boolean success = library.addBook(book1);
        assertTrue(success);
    }

    @Test
    public void addDuplicateBookTest() {
        addBookTest();

        Map<String, Object> book2 = createBook("978-0134685991", "Effective Java (2nd Copy)", "Joshua Bloch", 2018);

        boolean success = library.addBook(book2);
        assertFalse(success);
    }

    @Test
    public void borrowBookTest() {
        addBookTest();
        boolean success = library.borrowBook("978-0134685991");
        assertTrue(success);
    }

    @Test
    public void borrowBookAlreadyBorrowedTest() {
        borrowBookTest();
        boolean success = library.borrowBook("978-0134685991");
        assertFalse(success);
    }

    @Test
    public void borrowBookNotInListTest() {
        boolean success = library.borrowBook("123-4567890123"); // Non-existing ISBN
        assertFalse(success);
    }

    @Test
    public void returnBookTest() {
        borrowBookTest();
        boolean success = library.returnBook("978-0134685991");
        assertTrue(success);
    }

    @Test
    public void returnBookNotBorrowedTest() {
        addBookTest();
        boolean success = library.returnBook("978-0134685991");
        assertFalse(success);
    }
}
