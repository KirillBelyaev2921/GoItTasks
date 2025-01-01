package ua.kyrylo.bieliaiev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveFibonacciTest {

    @Test
    void fibonacci() {
        Fibonacci f = new RecursiveFibonacci();
        int n = 10;
        int expected = 55;

        long actual = f.fibonacci(n);
        assertEquals(expected, actual);
    }
}