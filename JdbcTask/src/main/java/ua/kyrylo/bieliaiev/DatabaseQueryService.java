package ua.kyrylo.bieliaiev;

import org.h2.tools.RunScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String sqlFilePath = "sql/find_max_salary_worker.sql";
        return executeCommand(sqlFilePath, resultSet -> {
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");
            return new MaxSalaryWorker(name, salary);
        });
    }

    private <R> List<R> executeCommand(String path, SqlFunction<ResultSet, R> function) {
        List<R> resultList = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection();
             ResultSet resultSet = RunScript.execute(connection, new FileReader(path))) {
            while (resultSet.next()) {
                resultList.add(function.apply(resultSet));
            }
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultList;
    }
}
