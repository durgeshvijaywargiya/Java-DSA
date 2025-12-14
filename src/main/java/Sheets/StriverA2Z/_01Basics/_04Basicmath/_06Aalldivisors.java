package Sheets.StriverA2Z._01Basics._04Basicmath;
import java.util.*;
/**
 * DivisorsSolutions.java
 * Combined FAANG-quality implementations for enumerating divisors of a positive integer.
 * Demo method executed in main: method2_sqrtPairNoSort
 */

public class _06Aalldivisors {

    // ------------------------------------------------------------
    // method1_bruteforce
    // ------------------------------------------------------------
    /**
     * Purpose:
     *  - Enumerate divisors by checking every integer from 1..n.
     * When to use:
     *  - Small n, or simplest correctness-first implementation.
     * Time: O(n)
     * Space: O(k)
     */
    public static List<Integer> method1_bruteforce(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) return res;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) res.add(i);
        }
        return res;
    }

    // ------------------------------------------------------------
    // method2_sqrtPairNoSort  (DEMO_METHOD)
    // ------------------------------------------------------------
    /**
     * Purpose:
     *  - Efficient divisor enumeration using sqrt pairing (no sorting required).
     * When to use:
     *  - Default method for enumerating divisors for a single integer.
     * Time: O(sqrt(n))
     * Space: O(k)
     */
    public static List<Integer> method2_sqrtPairNoSort(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) return res;

        List<Integer> large = new ArrayList<>();
        int limit = (int) Math.sqrt(n);
        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {
                res.add(i);
                int pair = n / i;
                if (pair != i) large.add(pair);
            }
        }
        // append large in reverse
        for (int i = large.size() - 1; i >= 0; i--) {
            res.add(large.get(i));
        }
        return res;
    }

    // ------------------------------------------------------------
    // method3_sqrtOriginalSorted
    // ------------------------------------------------------------
    /**
     * Purpose:
     *  - Original logic preserved: collect small & large, sort large, print ascending.
     * When to use:
     *  - Preserve legacy behavior or when sorting cost is acceptable.
     * Time: O(sqrt(n) + k log k)
     * Space: O(k)
     */
    public static void method3_sqrtSortedPrint(int n) {
        if (n <= 0) {
            System.out.println("Input must be a positive integer.");
            return;
        }

        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        int limit = (int) Math.sqrt(n);
        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {
                small.add(i);
                int pair = n / i;
                if (pair != i) large.add(pair);
            }
        }

        for (int v : small) System.out.print(v + " ");
        Collections.sort(large);
        for (int v : large) System.out.print(v + " ");
        System.out.println();
    }


    // ------------------------------------------------------------
    // Utility: printing helper using res list
    // ------------------------------------------------------------
    public static void printList(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("[no divisors]");
            return;
        }
        for (int v : list) System.out.print(v + " ");
        System.out.println();
    }

    // ------------------------------------------------------------
    // main: Demonstrate ONLY the DEMO_METHOD (method2_sqrtPairNoSort)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] tests = {1, 2, 3, 4, 12, 36, 37, 100, 99991}; // includes prime & composite & large-ish prime

        System.out.println("Demonstrating method2_sqrtPairNoSort (DEMO_METHOD):");
        for (int n : tests) {
            List<Integer> divisors = method2_sqrtPairNoSort(n);
            System.out.printf("n = %d -> divisors: ", n);
            printList(divisors);
        }


        // Demonstrate other methods:
        System.out.println("\nDemonstrate method3_sqrtSortedPrint for n=36:");
        method3_sqrtSortedPrint(36);

    }
}
