//ABDULLAH SHAHIR BIN ZULMAJDI 24000112

import java.sql.*;

public class Clients {
    public void addClient(String name, String phoneNumber, String address, int idSalesperson) {
        String query = "INSERT INTO clients (name, phonenumber, address, idsalespersons) VALUES (?, ?, ?, ?)";

        try (Connection connection = conn.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, address);
            statement.setInt(4, idSalesperson);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new client was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeClient(String name) {
        String query = "DELETE FROM clients WHERE name = ?";

        try (Connection connection = conn.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A client was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
