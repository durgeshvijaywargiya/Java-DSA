package Sheets.StriverA2Z._01Basics._05Recursion;

public class _08BNthfibonacci_Leetcode509 {

    // ------------------------------------------------------------
    // method1_iterative (BEST / DEMO METHOD)
    // ------------------------------------------------------------
    public static int method1_iterative(int n) {

        if (n <= 1) return n;

        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    // ------------------------------------------------------------
    // method2_recursive (Baseline)
    // ------------------------------------------------------------
    public static int method2_recursive(int n) {

        if (n <= 1) return n;
        return method2_recursive(n - 1) + method2_recursive(n - 2);
    }

    // ------------------------------------------------------------
    // method3_memoization
    // ------------------------------------------------------------
    public static int method3_memoization(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    private static int helper(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];

        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }

    // ------------------------------------------------------------
    // method4_tabulation
    // ------------------------------------------------------------
    public static int method4_tabulation(int n) {

        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // ------------------------------------------------------------
    // main — DEMO
    // ------------------------------------------------------------
    public static void main(String[] args) {

        int n = 10;

        System.out.println("DEMO METHOD: method1_iterative");
        System.out.println(method1_iterative(n)); // Expected: 55
    }
}
