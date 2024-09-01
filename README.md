# Library Management System

This project is implemented using a "HashMap" to manage the book data. Alternatively, you could refactor the code to use a "Book class" with getter and setter methods to handle different book attributes more explicitly. This approach might enhance code readability and maintainability. While many implementations use a "Book class", I chose to use a "HashMap" to introduce a unique approach to the problem.

## Project Overview

This project is a simple Library Management System developed using Java. It allows users to add, borrow, return, and view books in the library. The project follows a Test-Driven Development (TDD) approach, with comprehensive test cases to ensure the functionality of each feature.

## Features

- Add new books to the library
- Borrow books from the library
- Return borrowed books
- View available books in the library

## Prerequisites

- Java Development Kit (JDK) 22 or higher
- JUnit for testing
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, Visual Studio Code)

## Setup Instructions

1. Clone the repository:
    ```bash
    git clone <repository-link>
    ```
2. Navigate to the project directory:
    ```bash
    cd library-management-system
    ```
3. Open the project in your preferred IDE or text editor.

## Running the Tests

To run the test cases, follow these steps:

1. Ensure your IDE is set up to run JUnit tests.
2. Run the test cases located in `src/test/java/com/example/LibraryTest.java`.

## Version Control Strategy

The project follows a structured Git workflow, with meaningful commit messages that reflect the TDD process:

- Initial Setup : Repository initialization and project setup.
- Feature Implementation : Separate commits for adding, borrowing, returning, and viewing books.

## Contributing

If you'd like to contribute to this project, please fork the repository and submit a pull request. 