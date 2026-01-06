package Sheets.Lovebabbar._01Arrays._07rotateArray;
import java.util.Arrays;

public class _07C_rotateAntiClockWiseByK_GFG {

    // -----------------------------------------------------------
    // method1_extraArray (YOUR ORIGINAL APPROACH)
    // -----------------------------------------------------------
    /**
     * Rotates array left by k using extra array.

     * Time: O(n)
     * Space: O(n)
     */
    static void method1_extraArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(n - k + i) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // -----------------------------------------------------------
    // method2_extraArrayOptimised
    // -----------------------------------------------------------
    /**
     * Same logic as method1, but cleaner copy.
     */
    static void method2_extraArrayOptimised(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(n - k + i) % n] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }

    // -----------------------------------------------------------
    // method3_reversalAlgorithm (FAANG PREFERRED)
    // -----------------------------------------------------------
    /**
     * In-place left rotation using reversal algorithm.

     * Time: O(n)
     * Space: O(1)
     */
    static void method3_reversalAlgorithm(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    static void solution(int[] nums, int k) {
        method3_reversalAlgorithm(nums, k);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;

        System.out.println("Before: " + Arrays.toString(nums));
        solution(nums, k);
        System.out.println("After : " + Arrays.toString(nums));
    }
}
