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

}