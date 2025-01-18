package ua.kyrylo.bieliaiev;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseQueryServiceTest {

    DatabaseQueryService db = new DatabaseQueryService();

    @Test
    void testFindMaxSalaryWorker() {
        List<MaxSalaryWorker> maxSalaryWorkers = db.findMaxSalaryWorker();
        assertEquals(1, maxSalaryWorkers.size());
        assertEquals(new MaxSalaryWorker("Lynn", 10000), maxSalaryWorkers.get(0));
    }

    @Test
    void testFindMaxProjectsClient() {
        List<MaxProjectsClient> maxProjectsClients = db.findMaxProjectsClient();
        assertEquals(2, maxProjectsClients.size());
        assertEquals(new MaxProjectsClient("Kyrylo", 5), maxProjectsClients.get(0));
        assertEquals(new MaxProjectsClient("Dillan", 5), maxProjectsClients.get(1));
    }

}