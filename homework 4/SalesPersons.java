//DANISH SAFIN BIN ZULKARNAIN 24000149
//MUHAMMAD FAIQ HAKEEM BIN FARID 24000054

import java.sql.*;

public class SalesPersons {

    public void removeSalesperson(int id) {
        String query = "DELETE FROM salespersons WHERE idsalespersons = ?";

        try (Connection connection = conn.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A salesperson was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addSalesperson(int id, String name, String phoneNumber) {
        String query = "INSERT INTO salespersons (idsalespersons, name, phonenumber) VALUES (?, ?, ?)";

        try (Connection connection = conn.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, phoneNumber);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new salesperson was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
