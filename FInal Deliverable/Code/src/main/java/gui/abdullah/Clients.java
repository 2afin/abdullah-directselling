//ABDULLAH SHAHIR BIN ZULMAJDI 24000112

package gui.abdullah;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Clients {

    private static final String GET_ALL_CLIENTS_QUERY = "SELECT * FROM clients";
    private static final String INSERT_CLIENT_QUERY = "INSERT INTO clients (salespersonId, firstName, lastName, address, phoneNo) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_CLIENT_QUERY = "DELETE FROM clients WHERE firstName = ?";
    private static final String FIND_CLIENT_QUERY = "SELECT * FROM clients WHERE salespersonId = ?";

    public List<Client> getAllClients() throws SQLException {
        List<Client> clientList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_CLIENTS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int salespersonID = resultSet.getInt("salespersonId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String phoneNo = resultSet.getString("phoneNo");

                clientList.add(new Client(salespersonID, firstName, lastName, address, phoneNo));
            }
        }
        return clientList;
    }

    public void insert(Client client) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CLIENT_QUERY)) {

            statement.setInt(1, client.getSalespersonID());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getPhoneNo());

            statement.executeUpdate();
        }
    }

    public void delete(String firstName) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_QUERY)) {

            statement.setString(1, firstName);
            statement.executeUpdate();
        }
    }

    public Client findClientById(int salespersonId) throws SQLException {
        Client client = null;
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_CLIENT_QUERY)) {

            statement.setInt(1, salespersonId);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    int id = resultSet.getInt("salespersonId");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String address = resultSet.getString("address");
                    String phoneNo = resultSet.getString("phoneNo");

                    client = new Client(id, firstName, lastName, address, phoneNo);
                }
            }
        }
        return client;
    }
}
