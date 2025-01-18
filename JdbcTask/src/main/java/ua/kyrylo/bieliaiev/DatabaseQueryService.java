package ua.kyrylo.bieliaiev;

import org.h2.tools.RunScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public List<MaxProjectsClient> findMaxProjectsClient() {
        String sqlFilePath = "sql/find_max_projects_client.sql";
        return executeCommand(sqlFilePath, resultSet -> {
            String name = resultSet.getString("name");
            int projectCount = resultSet.getInt("project_count");
            return new MaxProjectsClient(name, projectCount);
        });
    }

    public List<LongestProject> findLongestProject() {
        String sqlFilePath = "sql/find_longest_project.sql";
        return executeCommand(sqlFilePath, resultSet -> {
            int projectId = resultSet.getInt("id");
            int months = resultSet.getInt("month_count");
            return new LongestProject(projectId, months);
        });
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        String sqlFilePath = "sql/find_youngest_eldest_workers.sql";
        return executeCommand(sqlFilePath, resultSet -> {
            String type = resultSet.getString("type");
            String name = resultSet.getString("name");
            LocalDate birthday = resultSet.getObject("birthday", LocalDate.class);
            return new YoungestEldestWorkers(type, name, birthday);
        });
    }

    public List<ProjectPrices> printProjectPrices() {
        String sqlFilePath = "sql/print_project_prices.sql";
        return executeCommand(sqlFilePath, resultSet -> {
            int projectId = resultSet.getInt("id");
            double price = resultSet.getDouble("price");
            return new ProjectPrices(projectId, price);
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
