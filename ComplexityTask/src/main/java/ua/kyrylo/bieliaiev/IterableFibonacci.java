package ua.kyrylo.bieliaiev;

public class IterableFibonacci implements Fibonacci {

    // time complexity: O(n)
    // space complexity: O(1)
    @Override
    public long fibonacci(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        if (n == 1) return 0;
        if (n == 2) return 1;
        long first = 0;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            long temp = result;
            result += first;
            first = temp;
        }
        return result;
    }
}
