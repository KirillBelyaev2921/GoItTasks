package ua.kyrylo.bieliaiev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DpFibonacciTest {

    @Test
    void fibonacci() {
        Fibonacci f = new DpFibonacci();
        int n = 10;
        int expected = 55;

        long actual = f.fibonacci(n);
        assertEquals(expected, actual);
    }
}