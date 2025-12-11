package Sheets.StriverA2Z._01Basics._04Basicmath;
        /*
        * Combined FAANG-level solutions for the "count digit" problem.
        *
        * Problem:
        *   "count digit"
        *   Given an integer n, return the number of digits in its decimal representation.
        *   - 0 has 1 digit.
        *   - Negative numbers are counted using their absolute value.
        */



public class _01countDigit_GFG {

    // ------------------------------------------------------------
    // method1_originalLike
    // ------------------------------------------------------------
    /**
     * method1_originalLike
     *
     * Purpose:
     * - Reflects the original logic (only counts digits for n > 0).
     *
     * When to use:
     * - For understanding the original behavior you started with.
     * - Not recommended in production due to incorrect handling of n <= 0.
     *
     * Time Complexity:  O(d) for n > 0
     * Space Complexity: O(1)
     */
    public static int method1_originalLike(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    // ------------------------------------------------------------
    // method2_doWhileIterative (DEMO_METHOD)
    // ------------------------------------------------------------
    /**
     * method2_doWhileIterative  (DEMO_METHOD in main)
     *
     * Purpose:
     * - Robust iterative approach using a do-while loop.
     * - Handles 0 and negative numbers correctly.
     *
     * When to use:
     * - Default recommended method for interviews and production.
     *
     * Time Complexity:  O(d)
     * Space Complexity: O(1)
     */
    public static int method2_doWhileIterative(int n) {
        int value = Math.abs(n);
        int count = 0;

        do {
            count++;
            value /= 10;
        } while (value != 0);

        return count;
    }

    // ------------------------------------------------------------
    // method3_whileIterative
    // ------------------------------------------------------------
    /**
     * method3_whileIterative
     *
     * Purpose:
     * - Robust iterative approach using a while loop with explicit 0 handling.
     *
     * When to use:
     * - When you want an explicit special case for 0 instead of do-while.
     *
     * Time Complexity:  O(d)
     * Space Complexity: O(1)
     */
    public static int method3_whileIterative(int n) {
        if (n == 0) {
            return 1;
        }

        int value = Math.abs(n);
        int count = 0;

        while (value > 0) {
            count++;
            value /= 10;
        }

        return count;
    }

    // ------------------------------------------------------------
    // method4_log10Based
    // ------------------------------------------------------------
    /**
     * method4_log10Based
     *
     * Purpose:
     * - Uses Math.log10 to compute digit count via logarithms.
     *
     * When to use:
     * - When you want to showcase mathematical insight or constant-time approach.
     *
     * Time Complexity:  O(1)
     * Space Complexity: O(1)
     */
    public static int method4_log10Based(int n) {
        if (n == 0) {
            return 1;
        }

        int value = Math.abs(n);

        return (int) (Math.floor(Math.log10(value)) + 1);
    }

    // ------------------------------------------------------------
    // method5_stringBased
    // ------------------------------------------------------------
    /**
     * method5_stringBased
     *
     * Purpose:
     * - Convert integer to string and use its length, adjusting for '-'.
     *
     * When to use:
     * - In non-performance-critical, high-level business logic
     *   where readability is more important than allocations.
     *
     * Time Complexity:  O(d)
     * Space Complexity: O(d)
     */
    public static int method5_stringBased(int n) {
        String s = String.valueOf(n);

        if (!s.isEmpty() && s.charAt(0) == '-') {
            return s.length() - 1;
        }

        return s.length();
    }

    // ------------------------------------------------------------
    // method6_thresholdBased
    // ------------------------------------------------------------
    /**
     * method6_thresholdBased
     *
     * Purpose:
     * - Count digits using fixed thresholds for 32-bit int.
     *
     * When to use:
     * - Performance-sensitive paths where even tiny loops matter.
     * - Systems code, formatting libraries, etc.
     *
     * Time Complexity:  O(1)
     * Space Complexity: O(1)
     */
    public static int method6_thresholdBased(int n) {
        int value = Math.abs(n);

        if (value < 10) {
            return 1;
        } else if (value < 100) {
            return 2;
        } else if (value < 1000) {
            return 3;
        } else if (value < 10000) {
            return 4;
        } else if (value < 100000) {
            return 5;
        } else if (value < 1000000) {
            return 6;
        } else if (value < 10000000) {
            return 7;
        } else if (value < 100000000) {
            return 8;
        } else if (value < 1000000000) {
            return 9;
        } else {
            return 10;
        }
    }

    // ------------------------------------------------------------
    // main: demonstrate ONLY the DEMO_METHOD (method2_doWhileIterative)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] testValues = {
                0,
                5,
                -5,
                10,
                99,
                100,
                12345,
                -12345,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE
        };

        System.out.println("Demonstrating method2_doWhileIterative (DEMO_METHOD):");
        for (int n : testValues) {
            int digits = method2_doWhileIterative(n);
            System.out.printf("n = %d -> digits = %d%n", n, digits);
        }

        // Other methods are available for manual testing:
        // method1_originalLike(n);
        // method3_whileIterative(n);
        // method4_log10Based(n);
        // method5_stringBased(n);
        // method6_thresholdBased(n);
    }
}

