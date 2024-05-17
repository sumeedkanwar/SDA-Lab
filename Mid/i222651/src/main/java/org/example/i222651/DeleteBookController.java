package org.example.i222651;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class DeleteBookController {
    @FXML
    private TableView<Book> bookTableView; // Corrected variable name

    private ObservableList<Book> bookList;

    public void setBookList(ObservableList<Book> bookList) {
        this.bookList = bookList;
    }

    @FXML
    private void initialize() {
        // Initialize bookList if it's null
        if (bookList == null) {
            bookList = FXCollections.observableArrayList();
        }

        // Load existing books from file
        loadBooksFromFile();

        // Clear existing columns to avoid duplicates
        bookTableView.getColumns().clear();

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

        bookTableView.getColumns().addAll(titleColumn, authorColumn, isbnColumn, availabilityColumn);

        // Enable sorting for columns
        titleColumn.setSortable(true);
        authorColumn.setSortable(true);
        isbnColumn.setSortable(true);

        // Allow single selection mode
        bookTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    private void deleteSelectedBook() {
        Book selectedBook = bookTableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            // Remove the book from the list
            bookList.remove(selectedBook);

            // Update the text file
            updateBooksFile();

            showAlert(Alert.AlertType.INFORMATION, "Delete Book", "Book deleted successfully.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a book to delete.");
        }
    }

    private void updateBooksFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : bookList) {
                String line = book.getTitle() + "," + book.getAuthor() + "," + book.getIsbn() + "," + book.isAvailable();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            // Handle file write error
            e.printStackTrace();
        }
    }

    private void loadBooksFromFile() {
        bookList.clear(); // Clear existing books before loading

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

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
