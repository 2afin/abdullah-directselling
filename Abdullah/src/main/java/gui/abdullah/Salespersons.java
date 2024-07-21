package gui.abdullah;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Salespersons {

    private static final String GET_ALL_TRANSACTIONS_QUERY = "SELECT * FROM salespersons";
    private static final String INSERT_TRANSACTION_QUERY = "INSERT INTO salespersons (salespersonId, firstName, lastName, address, phoneNo) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_TRANSACTION_QUERY = "DELETE FROM salespersons WHERE salespersonId = ?";

    public List<Salesperson> getAllSalespersons() throws SQLException {
        List<Salesperson> splist = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(GET_ALL_TRANSACTIONS_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int salespersonID = resultSet.getInt("salespersonId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String phoneNo = resultSet.getString("phoneNo");

                splist.add(new Salesperson(salespersonID, firstName, lastName, address, phoneNo));
            }
        } finally {
            Database.closeResources(resultSet, statement, connection);
        }

        return splist;
    }
    public void insert(Salesperson splist) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(INSERT_TRANSACTION_QUERY);
            statement.setInt(1, splist.getSalespersonID());
            statement.setString (2, splist.getFirstName());
            statement.setString (3, splist.getLastName());
            statement.setString (4, splist.getAddress());
            statement.setString (5, splist.getPhoneNo());

            statement.executeUpdate();
        } finally {
            Database.closeResources(null, statement, connection);
        }
    }

    public void delete(int salespersonId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(DELETE_TRANSACTION_QUERY);
            statement.setInt(1, salespersonId);

            statement.executeUpdate();
        } finally {
            Database.closeResources(null, statement, connection);
        }
    }
}