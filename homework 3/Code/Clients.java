//ABDULLAH SHAHIR BIN ZULMAJDI 24000112
package gui.homework3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Clients extends Stage {

    public void start(Stage primaryStage) {
        // Create a ListView to display client information
        ListView<String> clientListView = new ListView<>();

        // Add some dummy data to the ListView
        clientListView.getItems().addAll(
                "Client 1: Aqil, Jalan Busuk, Phone: 0122342342, SalesPerson: Fang",
                "Client 2: Yad, Jalan Wangi, Phone: 0122342342, SalesPerson: Zola"
        );

        // Create buttons for adding and removing clients
        Button addButton = new Button("Add Client");
        Button removeButton = new Button("Remove Client");

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(400, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        // Add the ListView and buttons to the pane
        pane.add(new Label("Clients:"), 0, 0);
        pane.add(clientListView, 0, 1, 7, 1);  // Spanning across 2 columns
        pane.add(addButton, 0, 2);
        pane.add(removeButton, 1, 2);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 400, 300);
        Stage stage = new Stage();
        stage.setTitle("Client Management");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    public void Client() {
        Stage stage = new Stage();
        start(stage);
    }
}
