package gui.abdullah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class ClientController {

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client, Number> salespersonIdCol;

    @FXML
    private TableColumn<Client, String> firstNameCol;

    @FXML
    private TableColumn<Client, String> lastNameCol;

    @FXML
    private TableColumn<Client, String> addressCol;

    @FXML
    private TableColumn<Client, String> phoneNoCol;

    @FXML
    private TextField searchField;

    @FXML
    private TextField salespersonIdField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneNoField;

    private ObservableList<Client> clientList = FXCollections.observableArrayList();

    private Clients cl = new Clients(); // Assuming Database class exists

    private MenuController menucon = new MenuController();

    public void initialize() {
        // Set up table columns
        salespersonIdCol.setCellValueFactory(cellData -> cellData.getValue().salespersonIdProperty());
        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        addressCol.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        phoneNoCol.setCellValueFactory(cellData -> cellData.getValue().phoneNoProperty());

        // Load initial data from database on startup
        loadClients();
    }

    public void loadClients() {
        clientList.clear();
        clientList.addAll(cl.getClients());
        clientTable.setItems(clientList);
    }

    public void searchClient(ActionEvent event) {
        String searchTerm = searchField.getText();
        clientList.clear();
        clientList.addAll(cl.searchClients(searchTerm));
        clientTable.setItems(clientList);
    }

    public void enterClient(ActionEvent event) {
        String idText = salespersonIdField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String phoneNo = phoneNoField.getText();

        if (idText.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || phoneNo.isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!", "Please fill all fields");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Invalid ID", "Salesperson ID must be an integer.");
            return;
        }

        Client newClient = new Client(id, firstName, lastName, address, phoneNo);
        boolean success = cl.addClient(newClient);

        if (success) {
            clientList.add(newClient);
            clientTable.setItems(clientList);
            clearInputFields();
        } else {
            showAlert(AlertType.ERROR, "Database Error", "Failed to add new client.");
        }
    }

    public void removeClient(ActionEvent event) {
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();

        if (selectedClient != null) {
            boolean success = cl.removeClient(selectedClient);

            if (success) {
                clientList.remove(selectedClient);
                clientTable.setItems(clientList);
            } else {
                showAlert(AlertType.ERROR, "Database Error", "Failed to remove client.");
            }
        } else {
            showAlert(AlertType.WARNING, "No Selection", "Please select a client to remove.");
        }
    }

    private void clearInputFields() {
        salespersonIdField.clear();
        firstNameField.clear();
        lastNameField.clear();
        addressField.clear();
        phoneNoField.clear();
    }

    private void showAlert(AlertType alertType, String title, String message) {
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
