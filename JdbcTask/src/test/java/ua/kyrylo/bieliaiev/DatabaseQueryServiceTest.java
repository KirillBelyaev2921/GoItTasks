package ua.kyrylo.bieliaiev;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseQueryServiceTest {

    @Test
    void testFindMaxSalaryWorker() {
        DatabaseQueryService db = new DatabaseQueryService();

        List<MaxSalaryWorker> maxSalaryWorkers = db.findMaxSalaryWorker();
        assertEquals(1, maxSalaryWorkers.size());
        assertEquals(new MaxSalaryWorker("Lynn", 10000), maxSalaryWorkers.get(0));
    }

}