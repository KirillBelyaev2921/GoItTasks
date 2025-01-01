package ua.kyrylo.bieliaiev;

public class RecursiveFibonacci implements Fibonacci {

    // time complexity: O(2^n)
    // space complexity: O(n)
    @Override
    public long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
