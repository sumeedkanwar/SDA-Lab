package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registration Form");
        

        TextField fullNameField = new TextField();
        DatePicker dobPicker = new DatePicker();
        
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        RadioButton otherRadio = new RadioButton("Other");
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        otherRadio.setToggleGroup(genderGroup);

        TextField emailField = new TextField();
        TextField contactField = new TextField();
        TextArea addressArea = new TextArea();
        
        ComboBox<String> courseComboBox = new ComboBox<>();
        courseComboBox.getItems().addAll("DataBase", "Probability and Statistics", "Fundamental of Management", "Software Design and Architecture");
        
        Button submitButton = new Button("Submit");

        // Labels
        Label fullNameLabel = new Label("Full Name:");
        Label birthLabel = new Label("Date of birth:");
        Label emailLabel = new Label("Email Address:");
        Label contactLabel = new Label("Contact Number:");
        Label genderLabel = new Label("Gender:");
        Label addressLabel = new Label("Address:");
        Label coursesLabel = new Label("Select Course:");

        GridPane gp = new GridPane();
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(10));

        gp.add(fullNameLabel, 0, 0);
        gp.add(fullNameField, 1, 0);

        gp.add(birthLabel, 0, 1);
        gp.add(dobPicker, 1, 1);

        gp.add(genderLabel, 0, 2);
        HBox genderSelector = new HBox(5, maleRadio, femaleRadio, otherRadio);
        gp.add(genderSelector, 1, 2);

        gp.add(addressLabel, 0, 3);
        gp.add(addressArea, 1, 3);

        gp.add(emailLabel, 0, 4);
        gp.add(emailField, 1, 4);

        gp.add(contactLabel, 0, 5);
        gp.add(contactField, 1, 5);

        gp.add(coursesLabel, 0, 6);
        gp.add(courseComboBox, 1, 6);

        gp.add(submitButton, 1, 7);

        Font labelFont = new Font("Arial", 12);
        fullNameLabel.setFont(labelFont);
        birthLabel.setFont(labelFont);
        genderLabel.setFont(labelFont);
        emailLabel.setFont(labelFont);
        contactLabel.setFont(labelFont);
        coursesLabel.setFont(labelFont);

        submitButton.setOnAction(event ->
        {
            if (isFormValid(fullNameField.getText(), dobPicker.getValue(), emailField.getText(), contactField.getText(), addressArea.getText(), courseComboBox.getValue()))
            {
            	Alert confirmationAlert = new Alert(Alert.AlertType.INFORMATION);
        		confirmationAlert.setTitle("Success");
        		confirmationAlert.setContentText("Registered!");
        		confirmationAlert.setHeaderText(null);
        		confirmationAlert.showAndWait();
        	}
            else
            {
        		Alert rejectionAlert = new Alert(Alert.AlertType.INFORMATION);
        		rejectionAlert.setTitle("Failure");
        		rejectionAlert.setContentText("Not Registered!");
        		rejectionAlert.setHeaderText(null);
        		rejectionAlert.showAndWait();
        	}
        });

        MenuBar menuBar = new MenuBar();
        Menu menuOptions = new Menu("Options");
        MenuItem clearFormItem = new MenuItem("Clear Form");
        MenuItem exitFormItem = new MenuItem("Exit Form");
        menuOptions.getItems().addAll(clearFormItem, exitFormItem);
        menuBar.getMenus().addAll(menuOptions);
        
        clearFormItem.setOnAction(event -> clearFormFields(fullNameField, dobPicker, genderGroup, emailField, contactField, addressArea, courseComboBox));

        exitFormItem.setOnAction(event -> primaryStage.close());

        VBox vbox = new VBox(menuBar, gp);
        vbox.setStyle("-fx-background-color: #B4D2BA;");
        Scene scene = new Scene(vbox, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isFormValid(String fullName, Object dob, String email, String contact, String address, String course)
    {
        return !fullName.isEmpty() && dob != null && !email.isEmpty() && !contact.isEmpty() && !address.isEmpty() && course != null;
    }

    private void clearFormFields(TextField fullNameField, DatePicker dobPicker, ToggleGroup genderGroup, TextField emailField, TextField contactField, TextArea addressArea, ComboBox<String> courseComboBox)
    {
        fullNameField.clear();
        dobPicker.setValue(null);
        genderGroup.selectToggle(null);
        emailField.clear();
        contactField.clear();
        addressArea.clear();
        courseComboBox.getSelectionModel().clearSelection();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
