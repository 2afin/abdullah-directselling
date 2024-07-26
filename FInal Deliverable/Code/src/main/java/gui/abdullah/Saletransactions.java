//MUHAMMAD FAIQ HAKEEM BIN FARID 24000054

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
    private static final String DELETE_TRANSACTION_QUERY = "DELETE FROM saletransactions WHERE product = ?";
    private static final String FIND_TRANSACTION_QUERY = "SELECT * FROM saletransactions WHERE salespersonId = ?";

    public List<Saletransaction> getAllTransactions() throws SQLException {
        List<Saletransaction> transactions = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_TRANSACTIONS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int salespersonID = resultSet.getInt("salespersonId");
                String product = resultSet.getString("product");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String date = resultSet.getString("date");

                transactions.add(new Saletransaction(salespersonID, product, price, quantity, date));
            }
        }
        return transactions;
    }

    public void insert(Saletransaction transaction) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TRANSACTION_QUERY)) {

            statement.setInt(1, transaction.getSalespersonID());
            statement.setString(2, transaction.getProduct());
            statement.setDouble(3, transaction.getPrice());
            statement.setInt(4, transaction.getQuantity());
            statement.setString(5, transaction.getDate());

            statement.executeUpdate();
        }
    }

    public void delete(String product) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TRANSACTION_QUERY)) {

            statement.setString(1, product);
            statement.executeUpdate();
        }
    }

    public Saletransaction findTransactionsById(int salespersonId) throws SQLException {
        Saletransaction saletransaction = null;
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_TRANSACTION_QUERY)) {

            statement.setInt(1, salespersonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("salespersonId");
                    String product = resultSet.getString("product");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("quantity");
                    String date = resultSet.getString("date");

                    saletransaction = new Saletransaction(id, product, price, quantity, date);
                }
            }
        }
        return saletransaction;
    }
}
