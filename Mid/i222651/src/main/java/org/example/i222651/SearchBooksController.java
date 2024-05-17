package org.example.i222651;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchBooksController {
    @FXML
    private TextField searchField;

    @FXML
    private TableView<Book> searchTableView;

    private ObservableList<Book> searchResults = FXCollections.observableArrayList();

    private ObservableList<Book> bookList;

    @FXML
    private void initialize() {
        // Initialize searchResults if it's null
        if (searchResults == null) {
            searchResults = FXCollections.observableArrayList();
        }

        // Load existing books from file
        loadBooksFromFile();

        // Clear existing columns to avoid duplicates
        searchTableView.getColumns().clear();

        // Set up columns in the TableView
        TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.setMinWidth(219);

        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorColumn.setMinWidth(150);

        TableColumn<Book, String> isbnColumn = new TableColumn<>("ISBN");
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        isbnColumn.setMinWidth(100);

        TableColumn<Book, Boolean> availabilityColumn = new TableColumn<>("Availability");
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        availabilityColumn.setMinWidth(100);

        searchTableView.getColumns().addAll(titleColumn, authorColumn, isbnColumn, availabilityColumn);

        // Enable sorting for columns
        titleColumn.setSortable(true);
        authorColumn.setSortable(true);
        isbnColumn.setSortable(true);

        // Allow single selection mode
        searchTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    private void searchBooks() {
        searchResults.clear(); // Clear previous search results

        String searchText = searchField.getText().trim().toLowerCase();

        if (searchText.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a search query.");
            return;
        }

        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(searchText) || book.getAuthor().toLowerCase().contains(searchText)) {
                searchResults.add(book);
            }
        }

        // Display search results in the TableView
        searchTableView.setItems(searchResults);
    }

    private void loadBooksFromFile() {
        bookList = FXCollections.observableArrayList(); // Initialize bookList

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
        searchTableView.setItems(bookList);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
