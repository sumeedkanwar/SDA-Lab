package org.example.i222651;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewAllBooksController {
    @FXML
    private TableView<Book> searchTableView;

    private ObservableList<Book> bookList;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> isbnColumn;

    @FXML
    private TableColumn<Book, Boolean> availabilityColumn;

    @FXML
    private void initialize() {
        // Initialize bookList if it's null
        if (bookList == null) {
            bookList = FXCollections.observableArrayList();
        }

        // Load books from the "books.txt" file
        loadBooksFromFile("books.txt");

        // Set the book list to the TableView
        searchTableView.setItems(bookList);

        // Set up columns in the TableView
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
    }

    // Load books from the specified file
    private void loadBooksFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
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
            e.printStackTrace();
        }
    }
}
