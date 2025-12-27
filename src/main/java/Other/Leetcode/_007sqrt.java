package Other.Leetcode;

public class _007sqrt {

    // ===========================================================
    // APPROACH 1: Newton's Method (YOUR SOLUTION - OPTIMAL)
    // ===========================================================
    /**
     * Computes integer square root using Newton's Method.

     * Time: O(log x)
     * Space: O(1)
     */
    public int mySqrt_newton(int x) {
        if (x < 2) return x;

        long r = x; // use long to avoid overflow

        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    // ===========================================================
    // APPROACH 2: Binary Search (FAANG SAFE FALLBACK)
    // ===========================================================
    /**
     * Computes integer square root using binary search.

     * Time: O(log x)
     * Space: O(1)
     */
    public int mySqrt_binarySearch(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= x) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    // ===========================================================
    // Recommended Default (Interview Choice)
    // ===========================================================
    public int solution(int x) {
        return mySqrt_newton(x);
    }

    // ===========================================================
    public static void main(String[] args) {
        _007sqrt solver = new _007sqrt();

        int x = 8;
        System.out.println("x = " + x);
        System.out.println("sqrt(x) = " + solver.solution(x));
    }
}
