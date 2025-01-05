package ua.kyrylo.bieliaiev;

import org.h2.tools.RunScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePopulateService {

    public static void main(String[] args) {
        String sqlFilePath = "JdbcTask/sql/populate_db.sql";

        try (Connection connection = Database.getInstance().getConnection()) {
            RunScript.execute(connection, new FileReader(sqlFilePath));
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
