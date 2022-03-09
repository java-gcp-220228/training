package com.revature.main;

import java.util.HashMap;

public class NumberUtility {

    // Time complexity O(2^n)
    public long calculateNthFib(int n) {
        if (n < 0) throw new IllegalArgumentException("n cannot be negative");

        if (n <= 1) return 1;

        return calculateNthFib(n - 1) + calculateNthFib(n - 2);
    }

    HashMap<Integer, Long> memoize = new HashMap<>();
    // Even though originally the recursive algorithm would be O(2^n), you can utilize "memoization" to optimize it
    // Memoization results in O(n)
    public long calculateNthFibMemoize(int n) {
        if (n < 0) throw new IllegalArgumentException("n cannot be negative");

        // Define a base case
        if (n <= 1) return 1;

        if (memoize.containsKey(n)) {
            return memoize.get(n);
        }

        memoize.put(n, calculateNthFibMemoize(n - 1) + calculateNthFibMemoize(n - 2));
        return memoize.get(n);
    }
}
