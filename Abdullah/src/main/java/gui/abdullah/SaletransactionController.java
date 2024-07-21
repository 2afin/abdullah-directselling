package gui.abdullah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class SaletransactionController {

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

    private Saletransactions saletransactions;
    private MenuController menucon = new MenuController();

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
                saletransactions.insertTransaction(transaction);
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
                saletransactions.deleteTransaction(selectedTransaction.getSalespersonID());
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

    private void clearFields() {
        salespersonIDField.clear();
        productField.clear();
        priceField.clear();
        quantityField.clear();
        dateField.clear();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (salespersonIDField.getText() == null || salespersonIDField.getText().isEmpty()) {
            errorMessage += "No valid salesperson ID!\n";
        }
        if (productField.getText() == null || productField.getText().isEmpty()) {
            errorMessage += "No valid product!\n";
        }
        if (priceField.getText() == null || priceField.getText().isEmpty()) {
            errorMessage += "No valid price!\n";
        }
        if (quantityField.getText() == null || quantityField.getText().isEmpty()) {
            errorMessage += "No valid quantity!\n";
        }
        if (dateField.getText() == null || dateField.getText().isEmpty()) {
            errorMessage += "No valid date!\n";
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            showAlert("Invalid Fields", errorMessage, Alert.AlertType.ERROR);
            return false;
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void ciao(ActionEvent event) throws IOException {
        menucon.exit(event);
    }
}
