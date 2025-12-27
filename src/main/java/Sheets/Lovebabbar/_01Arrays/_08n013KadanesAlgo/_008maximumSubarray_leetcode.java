package Sheets.Lovebabbar._01Arrays._08n013KadanesAlgo;

import java.util.Arrays;

public class _008maximumSubarray_leetcode {

    // ===========================================================
    // METHOD 1: Kadane’s Algorithm (Your Original Version)
    // ===========================================================
    /**
     * Uses running sum and resets when sum becomes negative.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int maxSubArray_kadaneOriginal(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;

        for (int x : nums) {
            localMax += x;
            globalMax = Math.max(globalMax, localMax);

            if (localMax < 0) {
                localMax = 0;
            }
        }
        return globalMax;
    }

    // ===========================================================
    // METHOD 2: Kadane’s Algorithm (Micro-Optimized & Canonical)
    // ===========================================================
    /**
     * Cleaner Kadane variant with fewer branches.
     * Handles all-negative arrays naturally.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int maxSubArray_kadaneOptimized(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // ===========================================================
    // METHOD 3: Prefix Sum Interpretation (Conceptual Variant)
    // ===========================================================
    /**
     * Prefix sum idea behind Kadane:
     * max subarray = prefix[j] - minPrefixBefore(j)
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int maxSubArray_prefixSum(int[] nums) {
        int prefixSum = 0;
        int minPrefix = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int x : nums) {
            prefixSum += x;
            maxSum = Math.max(maxSum, prefixSum - minPrefix);
            minPrefix = Math.min(minPrefix, prefixSum);
        }
        return maxSum;
    }

    // ===========================================================
    // METHOD 4: Divide & Conquer (Classic but Inferior)
    // ===========================================================
    /**
     * Divide & Conquer solution.
     *
     * Time: O(n log n)
     * Space: O(log n)
     *
     * Included for theoretical/interview discussion only.
     */
    public int maxSubArray_divideConquer(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;

        int leftMax = divide(nums, left, mid);
        int rightMax = divide(nums, mid + 1, right);
        int crossMax = crossSum(nums, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int crossSum(int[] nums, int left, int mid, int right) {
        int sum = 0, leftSum = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    // ===========================================================
    // RECOMMENDED DEFAULT (FAANG INTERVIEW CHOICE)
    // ===========================================================
    public int solution(int[] nums) {
        return maxSubArray_kadaneOptimized(nums);
    }

    // ===========================================================
    public static void main(String[] args) {
        _008maximumSubarray_leetcode solver = new _008maximumSubarray_leetcode();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Array        : " + Arrays.toString(nums));
        System.out.println("Max Subarray : " + solver.solution(nums));
    }
}
