package Sheets.StriverA2Z._01Basics._04Basicmath;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Merged FAANG-ready solutions for LeetCode 1979 (Find Greatest Common Divisor of Array).
 * Methods included:
 *  - method1_scanEuclid : Single-pass scan to find min/max, Euclidean gcd (RECOMMENDED)
 *  - method2_streams     : Uses Java Streams to get min and max (concise)
 *  - method3_sortBased   : Sort array then gcd of first & last (simple but O(n log n))
 * The public solution(...) method delegates to method1_scanEuclid by default.
 */

public class _04Bgcd_Leetcode1979 {

    // ============================
    /**
     * method1_scanEuclid
     * Purpose: Find min and max in one pass (O(n)), then compute gcd via Euclidean algorithm.
     * When to use: Default/recommended — optimal O(n) time and O(1) extra space.
     * Time Complexity: O(n + log(min,max)) => O(n)
     * Space Complexity: O(1)
     */
    public int method1_scanEuclid(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must be non-null and non-empty.");
        }

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int v : nums) {
            if (v < minVal) minVal = v;
            if (v > maxVal) maxVal = v;
        }

        return gcdEuclid(minVal, maxVal);
    }

    // ============================
    /**
     * method2_streams
     * Purpose: Use Java Streams to obtain min/max then gcd (concise).
     * When to use: When you prefer concise code and don't mind stream overhead.
     * Time Complexity: O(n) (may be two passes), Space Complexity: O(1) extra
     */
    public int method2_streams(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException("Input array must be non-null and non-empty.");

        OptionalInt minOpt = Arrays.stream(nums).min();
        OptionalInt maxOpt = Arrays.stream(nums).max();

        if (!minOpt.isPresent() || !maxOpt.isPresent()) return 0;

        return gcdEuclid(minOpt.getAsInt(), maxOpt.getAsInt());
    }

    // ============================
    /**
     * method3_sortBased
     * Purpose: Sort and pick first/last for gcd (simple but slower).
     * When to use: Quick implementation or when you need the sorted array anyway.
     * Time Complexity: O(n log n), Space Complexity: O(1) extra (sort overhead)
     */
    public int method3_sortBased(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Input array must be non-null and non-empty.");

        Arrays.sort(nums);
        return gcdEuclid(nums[0], nums[nums.length - 1]);
    }


    // ----------------------------
    // Helper: Euclidean gcd using long abs to avoid overflow on Integer.MIN_VALUE
    private int gcdEuclid(int a, int b) {
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

    // ----------------------------
    /**
     * Public API: recommended default solution
     * Delegates to method1_scanEuclid (single-pass + Euclid)
     */
    public int solution(int[] nums) {
        return method1_scanEuclid(nums);
    }

    // ----------------------------
    // Demo main
    public static void main(String[] args) {
        _04Bgcd_Leetcode1979 solver = new _04Bgcd_Leetcode1979();

        int[] example = {2, 5, 6, 9, 10};
        System.out.println("Input: " + Arrays.toString(example));

        int res = solver.solution(example);
        System.out.println("GCD of min and max: " + res);

        // Uncomment to test other methods
        // System.out.println("streams: " + solver.method2_streams(example));
        // System.out.println("sortBased: " + solver.method3_sortBased(example));
    }
}

