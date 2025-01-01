package ua.kyrylo.bieliaiev;

import java.util.HashMap;
import java.util.Map;

public class DpFibonacci implements Fibonacci {

    private Map<Integer, Long> dp = new HashMap<>();

    // time complexity: O(n)
    // space complexity: O(n)
    @Override
    public long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        long fib = fibonacci(n - 1) + fibonacci(n - 2);
        dp.put(n, fib);
        return fib;
    }

}
