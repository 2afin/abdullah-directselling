//ABDULLAH SHAHIR BIN ZULMAJDI 24000112
package gui.homework3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//press submit button to bring out list of clients
public class Client extends Stage {

    public Client() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Client Input");

        // Create Labels and TextFields for client information
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        Label phoneLabel = new Label("Phone:");
        TextField phoneField = new TextField();
        Label salesPersonLabel = new Label("Sales Person:");
        TextField salesPersonField = new TextField();

        // Create a Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(this::handleSubmitButtonAction);

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 200);
        pane.setVgap(10);
        pane.setHgap(10);

        // Add the labels and text fields to the pane
        pane.add(nameLabel, 0, 0);
        pane.add(nameField, 1, 0);
        pane.add(addressLabel, 0, 1);
        pane.add(addressField, 1, 1);
        pane.add(phoneLabel, 0, 2);
        pane.add(phoneField, 1, 2);
        pane.add(salesPersonLabel, 0, 3);
        pane.add(salesPersonField, 1, 3);
        pane.add(submitButton, 1, 4);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleSubmitButtonAction(ActionEvent event) {
        // Open the ClientsJFX window
        Clients clientsJFX = new Clients();
        try {
            clientsJFX.Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
