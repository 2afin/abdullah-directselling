//DZURIYAT ILHAN BIN MOHD RIDZUAN 24000061
//AHMAD AQIL FAHMI BIN AHMAD NOR 24000235

import java.sql.*;

public class SaleTransactions {
    public void addSalesTransaction(int idsaletransactions, String product, int quantity, double total, String date, int idSalesperson) {
        String query = "INSERT INTO saletransactions (idsaletransactions, product, quantity, total, date, idsalespersons) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = conn.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idsaletransactions);
            statement.setString(2, product);
            statement.setInt(3, quantity);
            statement.setDouble(4, total);
            statement.setString(5, date);
            statement.setInt(6, idSalesperson);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new sales transaction was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeSalesTransaction(int idTransaction) {
        String query = "DELETE FROM saletransactions WHERE idsaletransactions = ?";

        try (Connection connection = conn.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idTransaction);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A sales transaction was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}