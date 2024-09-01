package com.example;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;

public class LibraryTest {

    private Library library;

    // This method is executed before each test case. It initializes a new Library instance.
    @Before
    public void setUp() {
        library = new Library();
    }

    // Helper method to create a book as a map with the given properties.
    private Map<String, Object> createBook(String isbn, String title, String author, int year) {
        Map<String, Object> book = new HashMap<>();
        book.put("isbn", isbn);
        book.put("title", title);
        book.put("author", author);
        book.put("publicationYear", year);
        return book;
    }

    // Test adding a new book to the library and verifying it was added successfully.
    @Test
    public void addBookTest() {
        Map<String, Object> book1 = createBook("978-0134685991", "Effective Java", "Joshua Bloch", 2018);

        boolean success = library.addBook(book1);
        assertTrue(success); // Ensure the book was added successfully.
        assertEquals(1, library.viewAvailableBooks().size()); // Verify the number of available books in the library.
    }

    // Test adding a duplicate book (same ISBN) and verifying it is not added.
    @Test
    public void addDuplicateBookTest() {
        addBookTest(); // Add the first book.

        // Attempt to add a second copy of the same book (same ISBN).
        Map<String, Object> book2 = createBook("978-0134685991", "Effective Java", "Joshua Bloch", 2018);

        boolean success = library.addBook(book2);
        assertFalse(success); // Ensure the book was not added due to duplicate ISBN.
        assertEquals(1, library.viewAvailableBooks().size()); // Verify the number of available books remains the same.
    }

    // Test borrowing a book and verifying it is no longer available for borrowing.
    @Test
    public void borrowBookTest() {
        addBookTest(); // Add a book to the library.
        boolean success = library.borrowBook("978-0134685991");
        assertTrue(success); // Ensure the book was borrowed successfully.
        assertEquals(0, library.viewAvailableBooks().size()); // Verify the book is no longer available.
    }

    // Test borrowing a book that has already been borrowed and verifying it cannot be borrowed again.
    @Test
    public void borrowBookAlreadyBorrowedTest() {
        borrowBookTest(); // Borrow the book first.
        boolean success = library.borrowBook("978-0134685991");
        assertFalse(success); // Ensure the book cannot be borrowed again.
    }

    // Test borrowing a book that does not exist in the library.
    @Test
    public void borrowBookNotInListTest() {
        boolean success = library.borrowBook("123-4567890123"); // Attempt to borrow a non-existing book.
        assertFalse(success); // Ensure the book cannot be borrowed because it doesn't exist.
    }

    // Test returning a borrowed book and verifying it is available again for borrowing.
    @Test
    public void returnBookTest() {
        borrowBookTest(); // Borrow the book first.
        boolean success = library.returnBook("978-0134685991");
        assertTrue(success); // Ensure the book was returned successfully.
        assertEquals(1, library.viewAvailableBooks().size()); // Verify the book is available again.
    }

    // Test returning a book that was not borrowed and verifying it cannot be returned.
    @Test
    public void returnBookNotBorrowedTest() {
        addBookTest(); // Add a book to the library.
        boolean success = library.returnBook("978-0134685991");
        assertFalse(success); // Ensure the book cannot be returned because it wasn't borrowed.
    }

    // Test viewing the list of available books in the library.
    @Test
    public void viewAvailableBooksTest() {
        addBookTest(); // Add a book to the library.
        Collection<Map<String, Object>> availableBooks = library.viewAvailableBooks();
        assertEquals(1, availableBooks.size()); // Verify the number of available books is as expected.
    }
}
