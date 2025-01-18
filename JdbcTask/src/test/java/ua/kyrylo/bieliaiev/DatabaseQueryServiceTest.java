package ua.kyrylo.bieliaiev;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseQueryServiceTest {

    DatabaseQueryService db = new DatabaseQueryService();

    @Test
    void testFindMaxSalaryWorker() {
        List<MaxSalaryWorker> resultList = db.findMaxSalaryWorker();
        assertEquals(1, resultList.size());
        assertEquals(new MaxSalaryWorker("Lynn", 10000), resultList.get(0));
    }

    @Test
    void testFindMaxProjectsClient() {
        List<MaxProjectsClient> resultList = db.findMaxProjectsClient();
        assertEquals(2, resultList.size());
        assertEquals(new MaxProjectsClient("Kyrylo", 5), resultList.get(0));
        assertEquals(new MaxProjectsClient("Dillan", 5), resultList.get(1));
    }

    @Test
    void testFindLongestProject() {
        List<LongestProject> resultList = db.findLongestProject();
        assertEquals(1, resultList.size());
        assertEquals(new LongestProject(2, 32), resultList.get(0));
    }

    @Test
    void testFindYoungestEldestWorkers() {
        List<YoungestEldestWorkers> resultList = db.findYoungestEldestWorkers();
        assertEquals(2, resultList.size());
        assertEquals(new YoungestEldestWorkers("ELDEST", "Kyrylo", LocalDate.of(2001, 9, 2)), resultList.get(0));
        assertEquals(new YoungestEldestWorkers("YOUNGEST", "Lukas", LocalDate.of(1952, 12, 29)), resultList.get(1));
    }

    @Test
    void testPrintProjectPrices() {
        List<ProjectPrices> resultList = db.printProjectPrices();
        assertEquals(10, resultList.size());
        assertEquals(new ProjectPrices(10, 24000), resultList.get(0));
        assertEquals(new ProjectPrices(9, 14000), resultList.get(1));
        assertEquals(new ProjectPrices(8, 9000), resultList.get(2));
        assertEquals(new ProjectPrices(7, 4000), resultList.get(3));
        assertEquals(new ProjectPrices(5, 3100), resultList.get(4));
        assertEquals(new ProjectPrices(4, 2100), resultList.get(5));
        assertEquals(new ProjectPrices(6, 2000), resultList.get(6));
        assertEquals(new ProjectPrices(3, 1100), resultList.get(7));
        assertEquals(new ProjectPrices(2, 600), resultList.get(8));
        assertEquals(new ProjectPrices(1, 100), resultList.get(9));
    }

}