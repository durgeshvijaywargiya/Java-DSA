package Other.Leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class _001firstMissingPossitive_41 {

    // -----------------------------------------------------------
    // Helper swap
    // -----------------------------------------------------------
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // -----------------------------------------------------------
    // method1_cyclicSort (OPTIMAL - FAANG PREFERRED)
    // -----------------------------------------------------------
    /**
     * Uses cyclic sort / index placement.

     * Idea:
     * Place value x at index x-1 whenever possible.
     * Then scan for first index where nums[i] != i+1.

     * Time: O(n)
     * Space: O(1)
     */
    public int method1_cyclicSort(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 &&
                    nums[i] <= n &&
                    nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // -----------------------------------------------------------
    // method2_treeSet (Simple but slower)
    // -----------------------------------------------------------
    /**
     * Uses TreeSet to store positives in sorted order.

     * Time: O(n log n)
     * Space: O(n)
     */
    public int method2_treeSet(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();

        for (int x : nums) {
            if (x > 0) ts.add(x);
        }

        int expected = 1;
        for (int val : ts) {
            if (val != expected) return expected;
            expected++;
        }
        return expected;
    }

    // -----------------------------------------------------------
    // method3_treeSetToArray (Redundant variant)
    // -----------------------------------------------------------
    /**
     * TreeSet + array conversion.

     * Time: O(n log n)
     * Space: O(n)
     */
    public int method3_treeSetToArray(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : nums) {
            if (x > 0) ts.add(x);
        }

        if (ts.isEmpty()) return 1;

        int prev = 0;
        for (int curr : ts) {
            if (prev == 0 && curr != 1) return 1;
            if (prev != 0 && curr - prev != 1) return prev + 1;
            prev = curr;
        }
        return prev + 1;
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    public int solution(int[] nums) {
        return method1_cyclicSort(nums);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        _001firstMissingPossitive_41 solver =
                new _001firstMissingPossitive_41();

        int[] arr = {3, 4, -1, 1};
        System.out.println("Input : " + Arrays.toString(arr));
        System.out.println("Output: " + solver.solution(arr));
    }
}
