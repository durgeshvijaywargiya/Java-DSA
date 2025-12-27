package Other.Leetcode;
import java.util.*;

public class _004Absoulute_difference_of_minNmax {

    // ------------------------------------------------------------
    // method1_original (sorting)
    // ------------------------------------------------------------
    /**
     * SOLUTION IDEA (Sorting Based):
     * Steps:
     * 1. Sort the array.
     * 2. The first k elements after sorting are the k smallest.
     * 3. The last k elements after sorting are the k largest.
     * 4. Compute both sums and return their absolute difference.
     * Time Complexity:
     * - O(N log N) due to sorting
     * Space Complexity:
     * - O(1) extra (sorting in-place)
     */
    public static int method1_original(int[] nums, int k) {
        if (nums == null || k <= 0) return 0;

        Arrays.sort(nums);
        int left = 0, right = 0;

        for (int i = 0; i < k; i++) {
            left += nums[i];
            right += nums[nums.length - 1 - i];
        }

        return Math.abs(left - right);
    }

    // ------------------------------------------------------------
    // method3_heapBased
    // ------------------------------------------------------------
    /**
     * SOLUTION IDEA (Heap / PriorityQueue Based):

     * Goal:
     * - Find the absolute difference between:
     *      (sum of k smallest elements) and (sum of k largest elements)

     * Steps:
     * 1. Use a Min Heap to always extract the smallest element.
     * 2. Use a Max Heap to always extract the largest element.
     * 3. Insert all array elements into both heaps.
     * 4. Extract k times:
     *      - from Min Heap → accumulate smallest k sum
     *      - from Max Heap → accumulate largest k sum
     * 5. Return the absolute difference between the two sums.

     * Why Heaps?
     * - Avoids sorting the entire array.
     * - Useful when k is much smaller than N.

     * Time Complexity:
     * - Building heaps: O(N log N)
     * - Extracting k elements: O(k log N)

     * Space Complexity:
     * - O(N) due to two heaps
     */
    public static int method3_heapBased(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : nums) {
            minHeap.offer(x);
            maxHeap.offer(x);
        }

        int left = 0, right = 0;

        for (int i = 0; i < k; i++) {
            left += minHeap.poll();
            right += maxHeap.poll();
        }

        return Math.abs(left - right);
    }

    // ------------------------------------------------------------
    // main — DEMO
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 9, 2, 8};
        int k = 2;

        System.out.println("DEMO METHOD: method1_original");
        System.out.println(method1_original(nums, k)); // Expected: |(1+2)-(9+8)| = 14
    }
}
