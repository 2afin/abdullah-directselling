package gui.abdullah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class SalespersonController {

    @FXML
    private TableView<Salesperson> salespersonsTable;
    @FXML
    private TableColumn<Salesperson, Integer> salespersonIDCol;
    @FXML
    private TableColumn<Salesperson, String> firstNameCol;
    @FXML
    private TableColumn<Salesperson, String> lastNameCol;
    @FXML
    private TableColumn<Salesperson, String> addressCol;
    @FXML
    private TableColumn<Salesperson, String> phoneNoCol;

    @FXML
    private TextField salespersonIDField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNoField;

    private Salespersons salespersons;
    private MenuController menucon;

    @FXML
    public void initialize() {
        salespersonIDCol.setCellValueFactory(new PropertyValueFactory<>("salespersonID"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNoCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));

        salespersons = new Salespersons();
        loadSalespersons();
    }

    private void loadSalespersons() {
        try {
            ObservableList<Salesperson> splist = FXCollections.observableArrayList(salespersons.getAllSalespersons());
            salespersonsTable.setItems(splist);

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load salespersons: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleEnterSP(ActionEvent event) {
        try {
            if (isInputValid()) {
                int salespersonID = Integer.parseInt(salespersonIDField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                String phoneNo = phoneNoField.getText();

                Salesperson salesperson = new Salesperson(salespersonID, firstName, lastName, address, phoneNo);
                salespersons.insert(salesperson);
                loadSalespersons();
                clearFields();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to add salesperson: " + e.getMessage(), Alert.AlertType.ERROR);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            showAlert("Input Error", "Please enter valid numeric values for ID.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleRemoveSP(ActionEvent event) {
        Salesperson selectedsp = salespersonsTable.getSelectionModel().getSelectedItem();
        if (selectedsp != null) {
            try {
                salespersons.delete(selectedsp.getSalespersonID());
                loadSalespersons();
                salespersonsTable.getSelectionModel().clearSelection();

            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to delete salesperson: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            showAlert("No Selection", "Please select a salesperson to delete.", Alert.AlertType.WARNING);
        }
    }

    public void clearFields() {
        salespersonIDField.clear();
        firstNameField.clear();
        lastNameField.clear();
        addressField.clear();
        phoneNoField.clear();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (salespersonIDField.getText() == null || salespersonIDField.getText().isEmpty()) {
            errorMessage += "No valid salesperson ID!\n";
        }
        if (firstNameField.getText() == null || lastNameField.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().isEmpty()) {
            errorMessage += "No valid last name!\n";
        }
        if (addressField.getText() == null || addressField.getText().isEmpty()) {
            errorMessage += "No valid address!\n";
        }
        if (phoneNoField.getText() == null || phoneNoField.getText().isEmpty()) {
            errorMessage += "No valid phone number!\n";
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
        menucon = new MenuController();
        menucon.exit(event);
    }
}