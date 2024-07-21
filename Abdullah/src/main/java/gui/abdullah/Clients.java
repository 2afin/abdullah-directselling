package gui.abdullah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Clients {

    private Database db;

    private Connection connection;

    public Clients() {
        try {
            connection = db.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    public ObservableList<Client> getClients() {
        ObservableList<Client> clients = FXCollections.observableArrayList();
        String query = "SELECT * FROM clients";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("salespersonId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("address"),
                        resultSet.getString("phoneNo")
                );
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public boolean addClient(Client client) {
        String query = "INSERT INTO clients (salespersonId, firstName, lastName, address, phoneNo) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getSalespersonId());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getPhoneNo());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeClient(Client client) {
        String query = "DELETE FROM clients WHERE salespersonId = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getSalespersonId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ObservableList<Client> searchClients(String searchTerm) {
        ObservableList<Client> clients = FXCollections.observableArrayList();
        String query;

        if (searchTerm == null) {
            query = "SELECT * FROM clients";
        } else {
            query = "SELECT * FROM clients WHERE salespersonId LIKE ?";
        }

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            if (searchTerm != null) {
                String searchPattern = "%" + searchTerm + "%";
                statement.setString(1, searchPattern);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Client client = new Client(
                            resultSet.getInt("salespersonId"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("address"),
                            resultSet.getString("phoneNo")
                    );
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
}
