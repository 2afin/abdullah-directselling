//MUHAMMAD FAIQ HAKEEM BIN FARID 24000054
package gui.homework3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SalesPerson extends Stage {

    private TextField firstNameInput;
    private TextField middleNameInput;
    private TextField lastNameInput;
    private TextField phoneInput;

    public SalesPerson() {
        Stage stage = new Stage();
        stage.setTitle("Create Sales Person");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //first name label
        Label firstNameLabel = new Label("First Name:");
        GridPane.setConstraints(firstNameLabel, 0, 0);

        //first name input
        firstNameInput = new TextField();
        firstNameInput.setPromptText("Enter first name"); //put "Enter first name" inside the textfield box as a guide
        GridPane.setConstraints(firstNameInput, 1, 0);

        //middle name label
        Label middleNameLabel = new Label("Middle Name:");
        GridPane.setConstraints(middleNameLabel, 0, 1);

        //Middle name inoput
        middleNameInput = new TextField();
        middleNameInput.setPromptText("Enter middle name"); //put "Enter middle name" inside the textfield box as a guide
        GridPane.setConstraints(middleNameInput, 1, 1);

        //Last name label
        Label lastNameLabel = new Label("Last Name:");
        GridPane.setConstraints(lastNameLabel, 0, 2);

        //Last name input
        lastNameInput = new TextField();
        lastNameInput.setPromptText("Enter last name"); //put "Enter last name" inside the textfield box as a guide
        GridPane.setConstraints(lastNameInput, 1, 2);

        //Phone label
        Label phoneLabel = new Label("Phone Number:");
        GridPane.setConstraints(phoneLabel, 0, 3);

        //Phone input
        phoneInput = new TextField();
        phoneInput.setPromptText("Enter phone number"); //put "Enter phone number" inside the textfield box as a guide
        GridPane.setConstraints(phoneInput, 1, 3);

        //Submit button
        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 4);
        submitButton.setOnAction(e -> handleSubmit());

        //Adding elements
        grid.getChildren().addAll(firstNameLabel, firstNameInput, middleNameLabel, middleNameInput,
                lastNameLabel, lastNameInput, phoneLabel, phoneInput, submitButton);

        //Scne
        Scene scene = new Scene(grid, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void handleSubmit() {
        //Take user input
        String firstName = firstNameInput.getText();
        String middleName = middleNameInput.getText();
        String lastName = lastNameInput.getText();
        String phoneNumber = phoneInput.getText();

        //Display
        System.out.println("First Name: " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Phone Number: " + phoneNumber);
    }
}