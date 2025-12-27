package Sheets.Lovebabbar._01Arrays._07rotateArray;
import java.util.Arrays;

public class _007B_rotateClockwiseByK_Leetcode {

    // -----------------------------------------------------------
    // method1_reversalAlgorithm (FAANG PREFERRED)
    // -----------------------------------------------------------
    /**
     * Rotates array clockwise by k positions using reversal algorithm.
     *
     * Time: O(n)
     * Space: O(1)
     * In-place: YES
     */
    public void method1_reversalAlgorithm(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        k = k % n; // handle k > n

        reverse(nums, 0, n - 1);   // reverse whole array
        reverse(nums, 0, k - 1);   // reverse first k elements
        reverse(nums, k, n - 1);   // reverse remaining elements
    }

    // Helper method to reverse array segment
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // -----------------------------------------------------------
    // method2_extraArray (Simple baseline approach)
    // -----------------------------------------------------------
    /**
     * Rotates array clockwise by k using extra array.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public void method2_extraArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    public void solution(int[] nums, int k) {
        method1_reversalAlgorithm(nums, k);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        _007B_rotateClockwiseByK_Leetcode solver =
                new _007B_rotateClockwiseByK_Leetcode();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Before: " + Arrays.toString(nums));
        solver.solution(nums, k);
        System.out.println("After : " + Arrays.toString(nums));
    }
}

