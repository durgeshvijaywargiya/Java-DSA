package Sheets.Lovebabbar._01Arrays._03kthSmallest;
import java.util.*;
public class _03B_kthLargest_Leetcode {

    // ===========================================================
    // METHOD 1: Min-Heap of Size K (BETTER HEAP APPROACH)
    // ===========================================================
    /**
     * Maintains a min-heap of size k.
     *
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     */
    public int findKthLargest_minHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int v : nums) {
            minHeap.offer(v);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    // ===========================================================
    // METHOD 2: Max-Heap of Size N (BASELINE)
    // ===========================================================
    /**
     * Uses a max-heap containing all elements.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public int findKthLargest_maxHeap(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int v : nums) maxHeap.offer(v);

        for (int i = 1; i < k; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    // ===========================================================
    // METHOD 3: Quickselect (FAANG PREFERRED)
    // ===========================================================
    /**
     * Quickselect using partition logic.
     *
     * Average Time: O(n)
     * Worst Time: O(n^2)
     * Space: O(1)
     */
    public int findKthLargest_quickSelect(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;

        while (true) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public int solution(int[] nums, int k) {
        return findKthLargest_quickSelect(nums, k);
    }

    // ===========================================================
    public static void main(String[] args) {
        _03B_kthLargest_Leetcode solver =
                new _03B_kthLargest_Leetcode();

        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println("Kth Largest = " +
                solver.solution(nums, k));
    }
}
