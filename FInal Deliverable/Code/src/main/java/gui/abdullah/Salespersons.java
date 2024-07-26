//DANISH SAFIN BIN ZULKARNAIN 24000149

package gui.abdullah;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Salespersons {

    private static final String GET_ALL_SALESPERSONS_QUERY = "SELECT * FROM salespersons";
    private static final String INSERT_SALESPERSON_QUERY = "INSERT INTO salespersons (salespersonId, firstName, lastName, address, phoneNo) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_SALESPERSON_QUERY = "DELETE FROM salespersons WHERE salespersonId = ?";
    private static final String FIND_SALESPERSON_QUERY = "SELECT * FROM salespersons WHERE salespersonId = ?";

    public List<Salesperson> getAllSalespersons() throws SQLException {
        List<Salesperson> splist = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_SALESPERSONS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int salespersonID = resultSet.getInt("salespersonId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String phoneNo = resultSet.getString("phoneNo");

                splist.add(new Salesperson(salespersonID, firstName, lastName, address, phoneNo));
            }
        }
        return splist;
    }

    public void insert(Salesperson salesperson) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SALESPERSON_QUERY)) {

            statement.setInt(1, salesperson.getSalespersonID());
            statement.setString(2, salesperson.getFirstName());
            statement.setString(3, salesperson.getLastName());
            statement.setString(4, salesperson.getAddress());
            statement.setString(5, salesperson.getPhoneNo());

            statement.executeUpdate();
        }
    }

    public void delete(int salespersonId) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SALESPERSON_QUERY)) {

            statement.setInt(1, salespersonId);
            statement.executeUpdate();
        }
    }

    public Salesperson findSalespersonById(int salespersonId) throws SQLException {
        Salesperson salesperson = null;
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_SALESPERSON_QUERY)) {

            statement.setInt(1, salespersonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("salespersonId");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String address = resultSet.getString("address");
                    String phoneNo = resultSet.getString("phoneNo");

                    salesperson = new Salesperson(id, firstName, lastName, address, phoneNo);
                }
            }
        }
        return salesperson;
    }
}
