//DZURIYAT ILHAN BIN MOHD RIDZUAN 24000061
//AHMAD AQIL FAHMI BIN AHMAD NOR 24000235
package gui.homework3;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaleTransactiongui extends Stage{

    private TableView<SaleTransaction> table;
    private SaleTransactions saleTransactions;

    public SaleTransactiongui() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Sale Transactions");

        // Initialize SaleTransactions
        saleTransactions = new SaleTransactions();
        saleTransactions.add(new SaleTransaction("Product 1", 10, 15.5, "2024-07-01"));
        saleTransactions.add(new SaleTransaction("Product 2", 5, 9.99, "2024-07-02"));

        // Convert List to ObservableList
        ObservableList<SaleTransaction> data = FXCollections.observableArrayList(saleTransactions.getTransactions());

        // Table setup
        table = new TableView<>();
        table.setItems(data);

        TableColumn<SaleTransaction, String> productColumn = new TableColumn<>("Product");
        productColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduct()));

        TableColumn<SaleTransaction, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());

        TableColumn<SaleTransaction, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());

        TableColumn<SaleTransaction, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate()));

        table.getColumns().addAll(productColumn, quantityColumn, priceColumn, dateColumn);

        // Form to add new SaleTransaction
        TextField productField = new TextField();
        productField.setPromptText("Product");

        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");

        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        TextField dateField = new TextField();
        dateField.setPromptText("Date");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String product = productField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            String date = dateField.getText();

            SaleTransaction newTransaction = new SaleTransaction(product, quantity, price, date);
            saleTransactions.add(newTransaction);
            data.setAll(saleTransactions.getTransactions());

            productField.clear();
            quantityField.clear();
            priceField.clear();
            dateField.clear();
        });

        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> {
            SaleTransaction selectedTransaction = table.getSelectionModel().getSelectedItem();
            saleTransactions.remove(selectedTransaction);
            data.setAll(saleTransactions.getTransactions());
        });

        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Product:"), 0, 0);
        form.add(productField, 1, 0);
        form.add(new Label("Quantity:"), 0, 1);
        form.add(quantityField, 1, 1);
        form.add(new Label("Price:"), 0, 2);
        form.add(priceField, 1, 2);
        form.add(new Label("Date:"), 0, 3);
        form.add(dateField, 1, 3);
        form.add(addButton, 1, 4);
        form.add(removeButton, 1, 5);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, form);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
