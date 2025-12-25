package Other.Leetcode;

public class _002DivisorGame {

    // -----------------------------------------------------------
    // method1_parityLogic (OPTIMAL & FAANG EXPECTED)
    // -----------------------------------------------------------
    /**
     * Determines if Alice can win the Divisor Game.
     *
     * Key Insight:
     * - If n is even → Alice wins
     * - If n is odd  → Alice loses
     *
     * Time: O(1)
     * Space: O(1)
     */
    public boolean method1_parityLogic(int n) {
        return n % 2 == 0;
    }

    // -----------------------------------------------------------
    // Optional: DP-based explanation method (for understanding)
    // -----------------------------------------------------------
    /**
     * DP-based reasoning version (NOT needed in interview).
     * Shows how parity pattern emerges.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public boolean method2_dpExplanation(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;

        for (int i = 2; i <= n; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    public boolean solution(int n) {
        return method1_parityLogic(n);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        _002DivisorGame solver = new _002DivisorGame();

        for (int i = 1; i <= 10; i++) {
            System.out.println("n = " + i + " -> Alice wins? " + solver.solution(i));
        }
    }
}