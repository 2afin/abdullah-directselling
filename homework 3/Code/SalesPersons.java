//DANISH SAFIN BIN ZULKARNAIN 24000149
package gui.homework3;

import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

//shows a table of salespersons
//including their name, phnumber, list of clients, and their sales transaction

public class SalesPersons extends Stage {
    public SalesPersons() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SalesPersons.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            this.setScene(scene);
            this.setTitle("List of Sales Persons");
            this.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
