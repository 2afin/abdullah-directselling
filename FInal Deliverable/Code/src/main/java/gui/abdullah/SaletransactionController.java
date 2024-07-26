//MUHAMMAD FAIQ HAKEEM BIN FARID 24000054

package gui.abdullah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class SaletransactionController extends BaseController {

    @FXML
    private TableView<Saletransaction> transactionsTable;
    @FXML
    private TableColumn<Saletransaction, Integer> salespersonIDCol;
    @FXML
    private TableColumn<Saletransaction, String> productCol;
    @FXML
    private TableColumn<Saletransaction, Double> priceCol;
    @FXML
    private TableColumn<Saletransaction, Integer> quantityCol;
    @FXML
    private TableColumn<Saletransaction, String> dateCol;

    @FXML
    private TextField salespersonIDField;
    @FXML
    private TextField productField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField searchField;

    private Saletransactions saletransactions;
    private MenuController menucon;

    @FXML
    public void initialize() {
        salespersonIDCol.setCellValueFactory(new PropertyValueFactory<>("salespersonID"));
        productCol.setCellValueFactory(new PropertyValueFactory<>("product"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        saletransactions = new Saletransactions();
        loadTransactions();
    }

    private void loadTransactions() {
        try {
            ObservableList<Saletransaction> transactionsList = FXCollections.observableArrayList(saletransactions.getAllTransactions());
            transactionsTable.setItems(transactionsList);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load transactions: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleEnterST(ActionEvent event) {
        try {
            if (isInputValid()) {
                int salespersonID = Integer.parseInt(salespersonIDField.getText());
                String product = productField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                String date = dateField.getText();

                Saletransaction transaction = new Saletransaction(salespersonID, product, price, quantity, date);
                saletransactions.insert(transaction);
                loadTransactions();
                clearFields();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to add transaction: " + e.getMessage(), Alert.AlertType.ERROR);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            showAlert("Input Error", "Please enter valid numeric values for ID, price, and quantity.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleRemoveST(ActionEvent event) {
        Saletransaction selectedTransaction = transactionsTable.getSelectionModel().getSelectedItem();
        if (selectedTransaction != null) {
            try {
                saletransactions.delete(selectedTransaction.getProduct());
                loadTransactions();
                transactionsTable.getSelectionModel().clearSelection();
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to delete transaction: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            showAlert("No Selection", "Please select a transaction to delete.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void searchTransaction() {
        int salespersonId;
        try {
            salespersonId = Integer.parseInt(searchField.getText());
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid salesperson ID.", Alert.AlertType.ERROR);
            return;
        }

        try {
            Saletransaction saletransaction = saletransactions.findTransactionsById(salespersonId);
            if (saletransaction != null) {
                ObservableList<Saletransaction> data = FXCollections.observableArrayList(saletransaction);
                transactionsTable.setItems(data);
            } else {
                showAlert("Not Found", "No client found with the provided ID.", Alert.AlertType.WARNING);
                clearFields(salespersonIDField, productField, priceField, quantityField, dateField);
            }
        } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while searching for the client.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    public void ciao(ActionEvent event) throws IOException {
        menucon = new MenuController();
        menucon.exit(event);
    }
}
