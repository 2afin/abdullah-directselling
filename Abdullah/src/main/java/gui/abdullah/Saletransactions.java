package gui.abdullah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Saletransactions {

    private static final String GET_ALL_TRANSACTIONS_QUERY = "SELECT * FROM saletransactions";
    private static final String INSERT_TRANSACTION_QUERY = "INSERT INTO saletransactions (salespersonId, product, price, quantity, date) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_TRANSACTION_QUERY = "DELETE FROM saletransactions WHERE salespersonId = ?";

    public List<Saletransaction> getAllTransactions() throws SQLException {
        List<Saletransaction> transactions = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(GET_ALL_TRANSACTIONS_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int salespersonID = resultSet.getInt("salespersonId");
                String product = resultSet.getString("product");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String date = resultSet.getString("date");

                transactions.add(new Saletransaction(salespersonID, product, price, quantity, date));
            }
        } finally {
            Database.closeResources(resultSet, statement, connection);
        }

        return transactions;
    }

    public void insertTransaction(Saletransaction transaction) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(INSERT_TRANSACTION_QUERY);
            statement.setInt(1, transaction.getSalespersonID());
            statement.setString(2, transaction.getProduct());
            statement.setDouble(3, transaction.getPrice());
            statement.setInt(4, transaction.getQuantity());
            statement.setString(5, transaction.getDate());

            statement.executeUpdate();
        } finally {
            Database.closeResources(null, statement, connection);
        }
    }

    public void deleteTransaction(int salespersonId) throws SQLException {
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
