package org.example.i222651;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.SelectionMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class EditBookController {
    @FXML
    private TableView<Book> bookTableView;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField isbnField;

    @FXML
    private TextField availabilityField;

    @FXML
    private void initialize() {
        // Load existing books from file
        loadBooksFromFile();

        // Set the book list to the TableView
        bookTableView.setItems(bookList);

        // Set up columns defined in FXML file
        TableColumn<Book, String> titleColumn = (TableColumn<Book, String>) bookTableView.getColumns().get(0);
        TableColumn<Book, String> authorColumn = (TableColumn<Book, String>) bookTableView.getColumns().get(1);
        TableColumn<Book, String> isbnColumn = (TableColumn<Book, String>) bookTableView.getColumns().get(2);
        TableColumn<Book, Boolean> availabilityColumn = (TableColumn<Book, Boolean>) bookTableView.getColumns().get(3);

        // Set cell factories to display data in columns
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("available"));

        // Bind selected book's details to text fields for editing
        bookTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                titleField.setText(newValue.getTitle());
                authorField.setText(newValue.getAuthor());
                isbnField.setText(newValue.getIsbn());
                availabilityField.setText(newValue.isAvailable() ? "True" : "False");
            }
        });

        // Allow single selection mode
        bookTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    private void saveChanges() {
        Book selectedBook = bookTableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            // Update selected book's details with values from text fields
            selectedBook.setTitle(titleField.getText());
            selectedBook.setAuthor(authorField.getText());
            selectedBook.setIsbn(isbnField.getText());
            selectedBook.setAvailable(Boolean.parseBoolean(availabilityField.getText()));

            // Save the updated list to file
            saveBooksToFile();

            // Show success message
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book details updated successfully!");

            // Refresh the TableView after saving changes
            bookTableView.refresh();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a book to edit.");
        }
    }

    private void loadBooksFromFile() {
        if (!bookList.isEmpty()) {
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
                    bookList.add(new Book(title, author, isbn, available));
                }
            }
        } catch (IOException e) {
            // Handle file read error
            e.printStackTrace();
        }

        // Refresh the TableView to display the updated book list
        bookTableView.setItems(bookList);
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
}
