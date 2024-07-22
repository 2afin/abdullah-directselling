package gui.abdullah;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/abdullah";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

