//DANISH SAFIN BIN ZULKARNAIN 24000149

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

public class SalespersonController extends BaseController {

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
    @FXML
    private TextField searchField;

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
            showAlert("Error", "Failed to load salespersons: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleEnterSP(ActionEvent event) {
        try {
            if (isInputValid(salespersonIDField, firstNameField, lastNameField, addressField, phoneNoField)) {
                int salespersonID = Integer.parseInt(salespersonIDField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                String phoneNo = phoneNoField.getText();

                Salesperson salesperson = new Salesperson(salespersonID, firstName, lastName, address, phoneNo);
                salespersons.insert(salesperson);
                loadSalespersons();
                clearFields(salespersonIDField, firstNameField, lastNameField, addressField, phoneNoField);
            }
        } catch (SQLException e) {
            showAlert("Error", "Failed to add salesperson: " + e.getMessage(), Alert.AlertType.ERROR);
        } catch (NumberFormatException e) {
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
                showAlert("Error", "Failed to delete salesperson: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            showAlert("No Selection", "Please select a salesperson to delete.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void searchSalesperson() {
        int salespersonId;
        try {
            salespersonId = Integer.parseInt(searchField.getText());
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid salesperson ID.", Alert.AlertType.ERROR);
            return;
        }

        try {
            Salesperson salesperson = salespersons.findSalespersonById(salespersonId);
            if (salesperson != null) {
                ObservableList<Salesperson> data = FXCollections.observableArrayList(salesperson);
                salespersonsTable.setItems(data);
            } else {
                showAlert("Not Found", "No salesperson found with the provided ID.", Alert.AlertType.WARNING);
                clearFields(salespersonIDField, firstNameField, lastNameField, addressField, phoneNoField);
            }
        } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while searching for the salesperson.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void ciao(ActionEvent event) throws IOException {
        menucon = new MenuController();
        menucon.exit(event);
    }
}
