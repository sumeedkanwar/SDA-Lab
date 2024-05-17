package org.example.i222651;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AddBookController {
    private List<Book> bookList;

    @FXML
    private TextField bookTitleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField isbnField;

    @FXML
    private void initialize() {
        // Load existing books from file
        loadBooksFromFile();
    }

    @FXML
    private void onAddBookButtonClick() {
        String title = bookTitleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();

        if (title.isEmpty() || author.isEmpty() || !Pattern.matches("^(97(8|9))?[0-9]{9}([0-9]|X)$", isbn)) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input or ISBN");
        } else {
            // Add new book to the list
            Book newBook = new Book(title, author, isbn);
            bookList.add(newBook);

            // Save the updated list to file
            saveBooksToFile();

            // Show success message
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book added successfully!");

            // Clear input fields
            clearFields();
        }
    }

    private void loadBooksFromFile() {
        // Initialize bookList if null
        if (bookList == null) {
            bookList = new ArrayList<>();
        } else {
            bookList.clear(); // Clear existing books before loading
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String title = parts[0];
                    String author = parts[1];
                    String isbn = parts[2];
                    boolean available = Boolean.parseBoolean(parts[3]);
                    bookList.add(new Book(title, author, isbn));
                }
            }
        } catch (IOException e) {
            // Handle file read error
            e.printStackTrace();
        }
    }

    private void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : bookList) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," +
                        book.getIsbn() + "," + book.isAvailable() + "\n");
            }
        } catch (IOException e) {
            // Handle file write error
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        bookTitleField.clear();
        authorField.clear();
        isbnField.clear();
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
