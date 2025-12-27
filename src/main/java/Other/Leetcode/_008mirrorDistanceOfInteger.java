package Other.Leetcode;

public class _008mirrorDistanceOfInteger {

    // ===========================================================
    // APPROACH: Reverse Integer + Absolute Difference
    // ===========================================================
    /**
     * Computes the mirror distance of an integer.

     * Mirror Distance = |n - reverse(n)|

     * Time: O(d) where d = number of digits
     * Space: O(1)
     */
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    /**
     * Reverses the digits of a non-negative integer.
     */
    private int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return rev;
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public int solution(int n) {
        return mirrorDistance(n);
    }

    // ===========================================================
    public static void main(String[] args) {
        _008mirrorDistanceOfInteger solver =
                new _008mirrorDistanceOfInteger();

        int n = 25;
        System.out.println("n = " + n);
        System.out.println("Mirror Distance = " + solver.solution(n));
    }
}

