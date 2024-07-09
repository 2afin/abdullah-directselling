//DANISH SAFIN BIN ZULKARNAIN 24000149
package gui.homework3;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage meow) throws Exception {
        new Client();
        new SalesPerson();
        new SalesPersons();
        new SaleTransactiongui();
    }
}
