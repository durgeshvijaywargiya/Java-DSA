package Sheets.StriverA2Z._01Basics._04Basicmath;
/**
         * GcdSolutions.java
         * Combined FAANG-quality implementations for computing GCD.

        * Methods:
         *  - method1_bruteforceOriginal       : Brute-force downward divisor search (original logic)
         *  - method2_euclidIterative          : Euclidean algorithm (iterative)  <-- DEMO_METHOD
         *  - method3_euclidRecursive          : Euclidean algorithm (recursive)
         *  - method4_gcdOfArray               : GCD of an integer array
         * Demo method executed in main: method3_euclidIterative
*/

public class _04Agcd__GFG {

    // method1_bruteforceOriginal

    /**
     * Purpose:
     *  - Preserve original brute-force logic: check divisors downward from min(|a|,|b|).
     * When to use:
     *  - Educational / demonstration of naive approach.
     * Time Complexity: O(min(|a|, |b|))
     * Space Complexity: O(1)
     */
    public static int method1_bruteforceOriginal(int a, int b) {
        if (a == 0 && b == 0) return 0;

        int aa = Math.abs(a);
        int bb = Math.abs(b);

        int result = Math.min(aa, bb);
        while (result > 0) {
            if (aa % result == 0 && bb % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }


    // ------------------------------------------------------------
    // method2_euclidIterative  (DEMO_METHOD)
    // ------------------------------------------------------------
    /**
     * Purpose:
     *  - Fast, production-ready Euclidean iterative algorithm.
     * When to use:
     *  - Default for interviews and production.
     * Time Complexity: O(log(min(|a|, |b|)))
     * Space Complexity: O(1)
     */
    public static int method2_euclidIterative(int a, int b) {
        if (a == 0 && b == 0) return 0;

        long x = Math.abs((long) a);
        long y = Math.abs((long) b);

        while (y != 0) {
            long r = x % y;
            x = y;
            y = r;
        }
        return (int) x;
    }


    // method3_euclidRecursive

    /**
     * Purpose:
     *  - Recursive Euclidean algorithm (clear and concise).
     * When to use:
     *  - When recursion clarity is preferred and input sizes are small enough for stack use.
     * Time Complexity: O(log(min(|a|, |b|)))
     * Space Complexity: O(log(min(|a|, |b|))) recursion stack
     */
    public static int method3_euclidRecursive(int a, int b) {
        if (a == 0 && b == 0) return 0;
        long x = Math.abs((long) a);
        long y = Math.abs((long) b);
        return (int) gcdRecLong(x, y);
    }

    private static long gcdRecLong(long x, long y) {
        if (y == 0) return x;
        return gcdRecLong(y, x % y);
    }


    // ------------------------------------------------------------
    // method4_gcdOfArray
    // ------------------------------------------------------------
    /**
     * Purpose:
     *  - Compute gcd of an array of integers by iteratively reducing pairs.
     * When to use:
     *  - Normalize sets of integers, compute step-size for arithmetic progressions, etc.
     * Time Complexity: O(n * log M) where M is magnitude of numbers
     * Space Complexity: O(1)
     */
    public static int method4_gcdOfArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        long current = Math.abs((long) arr[0]);
        for (int i = 1; i < arr.length; i++) {
            current = gcdLong(current, Math.abs((long) arr[i]));
            if (current == 1) return 1; // early termination
        }
        return (int) current;
    }

    // helper for array reduction
    private static long gcdLong(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // ------------------------------------------------------------
    // main: Demonstrate ONLY the DEMO_METHOD (method3_euclidIterative)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[][] testPairs = {
                {48, 18},
                {0, 0},
                {0, 5},
                {7, 3},
                {270, 192},
                {-24, 36},
                {Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MIN_VALUE, 1}
        };

        System.out.println("Demonstrating method2_euclidIterative (DEMO_METHOD):");
        for (int[] pair : testPairs) {
            int a = pair[0], b = pair[1];
            int g = method2_euclidIterative(a, b);
            System.out.printf("gcd(%d, %d) = %d%n", a, b, g);
        }

        // Example for array gcd
        int[] arr = {12, 30, 18};
        System.out.printf("gcdOfArray(%s) = %d%n", java.util.Arrays.toString(arr), method4_gcdOfArray(arr));
    }
}



