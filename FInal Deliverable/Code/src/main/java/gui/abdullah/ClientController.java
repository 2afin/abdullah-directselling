//ABDULLAH SHAHIR BIN ZULMAJDI 24000112

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

public class ClientController extends BaseController {

    @FXML
    private TableView<Client> clientsTable;
    @FXML
    private TableColumn<Client, Integer> salespersonIDCol;
    @FXML
    private TableColumn<Client, String> firstNameCol;
    @FXML
    private TableColumn<Client, String> lastNameCol;
    @FXML
    private TableColumn<Client, String> addressCol;
    @FXML
    private TableColumn<Client, String> phoneNoCol;

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

    private Clients clients;
    private MenuController menucon;

    @FXML
    public void initialize() {
        salespersonIDCol.setCellValueFactory(new PropertyValueFactory<>("salespersonID"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNoCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));

        clients = new Clients();
        loadClients();
    }

    private void loadClients() {
        try {
            ObservableList<Client> splist = FXCollections.observableArrayList(clients.getAllClients());
            clientsTable.setItems(splist);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load clients: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleEnterCL(ActionEvent event) {
        try {
            if (isInputValid(salespersonIDField, firstNameField, lastNameField, addressField, phoneNoField)) {
                int salespersonID = Integer.parseInt(salespersonIDField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                String phoneNo = phoneNoField.getText();

                Client client = new Client(salespersonID, firstName, lastName, address, phoneNo);
                clients.insert(client);
                loadClients();
                clearFields(salespersonIDField, firstNameField, lastNameField, addressField, phoneNoField);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to add client: " + e.getMessage(), Alert.AlertType.ERROR);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            showAlert("Input Error", "Please enter valid numeric values for ID.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleRemoveCL(ActionEvent event) {
        Client selectedcl = clientsTable.getSelectionModel().getSelectedItem();
        if (selectedcl != null) {
            try {
                clients.delete(selectedcl.getFirstName());
                loadClients();
                clientsTable.getSelectionModel().clearSelection();
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to delete client: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            showAlert("No Selection", "Please select a client to delete.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void searchClient() {
        int salespersonId;
        try {
            salespersonId = Integer.parseInt(searchField.getText());
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid salesperson ID.", Alert.AlertType.ERROR);
            return;
        }

        try {
            Client client = clients.findClientById(salespersonId);
            if (client != null) {
                ObservableList<Client> data = FXCollections.observableArrayList(client);
                clientsTable.setItems(data);
            } else {
                showAlert("Not Found", "No client found with the provided ID.", Alert.AlertType.WARNING);
                clearFields(salespersonIDField, firstNameField, lastNameField, addressField, phoneNoField);
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
