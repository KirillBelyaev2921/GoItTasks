package ua.kyrylo.bieliaiev;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String statement = """
                SELECT NAME, SALARY
                FROM worker
                WHERE SALARY =
                      (SELECT MAX(SALARY) FROM worker)
                """;
        return executeCommand(statement, resultSet -> {
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");
            return new MaxSalaryWorker(name, salary);
        });
    }

    public List<MaxProjectsClient> findMaxProjectsClient() {
        String statement = """
                SELECT NAME, COUNT(ID) AS PROJECT_COUNT
                FROM worker w
                         JOIN project_worker pw on w.ID = pw.WORKER_ID
                GROUP BY ID
                HAVING PROJECT_COUNT =
                       (SELECT MAX(x.count)
                        FROM (SELECT COUNT(ID) count
                              FROM worker w
                                       JOIN project_worker pw on w.ID = pw.WORKER_ID
                              GROUP BY ID) x)
                """;
        return executeCommand(statement, resultSet -> {
            String name = resultSet.getString("name");
            int projectCount = resultSet.getInt("project_count");
            return new MaxProjectsClient(name, projectCount);
        });
    }

    public List<LongestProject> findLongestProject() {
        String statement = """
                SELECT ID, DATEDIFF(MONTH, START_DATE, FINISH_DATE) AS MONTH_COUNT
                FROM project p
                WHERE DATEDIFF(MONTH, START_DATE, FINISH_DATE) =
                       (SELECT MAX(x.count)
                        FROM (SELECT DATEDIFF(MONTH, START_DATE, FINISH_DATE) count
                              FROM project p) x)
                """;
        return executeCommand(statement, resultSet -> {
            int projectId = resultSet.getInt("id");
            int months = resultSet.getInt("month_count");
            return new LongestProject(projectId, months);
        });
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        String statement = """
                SELECT 'YOUNGEST' TYPE, NAME, BIRTHDAY FROM worker
                WHERE BIRTHDAY =
                      (SELECT MIN(BIRTHDAY) FROM worker)
                UNION
                SELECT 'ELDEST' TYPE, NAME, BIRTHDAY FROM worker
                WHERE BIRTHDAY =
                      (SELECT MAX(BIRTHDAY) FROM worker);
                """;
        return executeCommand(statement, resultSet -> {
            String type = resultSet.getString("type");
            String name = resultSet.getString("name");
            LocalDate birthday = resultSet.getObject("birthday", LocalDate.class);
            return new YoungestEldestWorkers(type, name, birthday);
        });
    }

    public List<ProjectPrices> printProjectPrices() {
        String statement = """
                SELECT p.ID, SUM(SALARY) PRICE FROM PROJECT p
                INNER JOIN project_worker pw ON p.ID = PW.PROJECT_ID
                INNER JOIN worker w ON pw.WORKER_ID = w.ID
                GROUP BY p.ID
                ORDER BY PRICE DESC;
                """;
        return executeCommand(statement, resultSet -> {
            int projectId = resultSet.getInt("id");
            double price = resultSet.getDouble("price");
            return new ProjectPrices(projectId, price);
        });
    }

    private <R> List<R> executeCommand(String query, SqlFunction<ResultSet, R> function) {
        List<R> resultList = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    resultList.add(function.apply(resultSet));
                }
            }

        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultList;
    }
}
