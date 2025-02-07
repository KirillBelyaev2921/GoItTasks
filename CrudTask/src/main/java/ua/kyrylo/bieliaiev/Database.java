package ua.kyrylo.bieliaiev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance = null;

    private final Connection connection;

    private Database() throws SQLException {
        String url = "jdbc:h2:~/test";
        connection = DriverManager.getConnection(url, "sa", "");
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
