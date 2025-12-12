package Sheets.Lovebabbar._01Arrays;
import java.util.*;


/**
 * KthSmallestSolution: merged class containing multiple approaches.

 * Methods:
 * - method1_sort: sort and index (O(n log n))
 * - method2_minHeapPoll: min-heap and poll k times (O(n + k log n))
 * - method3_maxHeapFixedSize: max-heap of size k (O(n log k)) — recommended when k << n
 * - method4_quickselect: Quickselect (expected O(n)) — best average performance

 * The DEMO_METHOD is 'method2' (min-heap poll) as requested; main() demonstrates method2.

 * Behavior for invalid inputs:
 * - arr == null -> IllegalArgumentException
 * - k <= 0 or k > arr.length -> IllegalArgumentException

 * This file compiles as-is in IntelliJ.
 */

public class _003_kthSmallest_GFG {

    // =========================
    // method1_sort
    // Purpose: simple, correct — sort array and pick k-1.
    // When: quick scripts or when array already needs sorting.
    // Time: O(n log n) | Space: O(1) extra (sorting overhead)
    // =========================
    public int method1_sort(int[] arr, int k) {
        if (arr == null) throw new IllegalArgumentException("arr == null");
        int n = arr.length;
        if (k <= 0 || k > n) throw new IllegalArgumentException("k out of range");

        Arrays.sort(arr);
        return arr[k - 1];
    }

    // =========================
    // method2_minHeapPoll
    // Purpose: use min-heap, poll k-1 times then return root
    // When: educational/demonstrative; not optimal compared to method3 for k << n
    // Time: O(n log n) in practice when adding all elements by offers, plus O(k log n) to poll; overall worse than method3 when k is small.
    // Space: O(n)
    // =========================
    public int method2_minHeapPoll(int[] arr, int k) {
        if (arr == null) throw new IllegalArgumentException("arr == null");
        int n = arr.length;
        if (k <= 0 || k > n) throw new IllegalArgumentException("k out of range");

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);
        for (int v : arr) minHeap.offer(v);

        for (int i = 1; i < k; i++) minHeap.poll();
        return minHeap.poll();
    }

    // =========================
    // method3_maxHeapFixedSize
    // Purpose: keep a max-heap of size k containing k smallest elements; root is kth smallest
    // When: production use when k is much smaller than n (O(n log k))
    // Time: O(n log k) | Space: O(k)
    // =========================
    public int method3_maxHeapFixedSize(int[] arr, int k) {
        if (arr == null) throw new IllegalArgumentException("arr == null");
        int n = arr.length;
        if (k <= 0 || k > n) throw new IllegalArgumentException("k out of range");

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int v : arr) {
            maxHeap.offer(v);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    // =========================
    // method4_quickselect
    // Purpose: Quickselect to get kth smallest in expected linear time (in-place)
    // When: n large and you want average O(n) performance
    // Time: Average O(n), Worst O(n^2) (randomized pivot reduces worst-case likelihood)
    // Space: O(1) extra (in-place), O(log n) recursion/loop
    // =========================
    private final Random rand = new Random();

    public int method4_quickselect(int[] arr, int k) {
        if (arr == null) throw new IllegalArgumentException("arr == null");
        int n = arr.length;
        if (k <= 0 || k > n) throw new IllegalArgumentException("k out of range");
        // Quickselect mutates the array in-place for speed
        return quickselect(arr, 0, n - 1, k - 1);
    }

    private int quickselect(int[] a, int left, int right, int kIndex) {
        while (left <= right) {
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int pivotFinal = partition(a, left, right, pivotIndex);
            if (pivotFinal == kIndex) return a[pivotFinal];
            else if (kIndex < pivotFinal) right = pivotFinal - 1;
            else left = pivotFinal + 1;
        }
        throw new IllegalStateException("Quickselect failed");
    }

    private int partition(int[] a, int left, int right, int pivotIndex) {
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, right);
        int store = left;
        for (int i = left; i < right; i++) {
            if (a[i] < pivot) {
                swap(a, store, i);
                store++;
            }
        }
        swap(a, store, right);
        return store;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // =========================
    // DEMO METHOD: solution delegates to method2 (min-heap poll) as requested
    // =========================
    public int solution(int[] arr, int k) {
        return method2_minHeapPoll(arr, k);
    }

    // Demo main — shows DEMO_METHOD usage
    public static void main(String[] args) {
        _003_kthSmallest_GFG solver = new _003_kthSmallest_GFG();
        int[] example = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Input: " + Arrays.toString(example) + ", k=" + k);

        int kth = solver.solution(Arrays.copyOf(example, example.length), k);
        System.out.println(k + "th smallest (method2_minHeapPoll): " + kth);

        // Examples to test other methods:
        // System.out.println("method1_sort: " + solver.method1_sort(Arrays.copyOf(example, example.length), k));
        // System.out.println("method3_maxHeapFixedSize: " + solver.method3_maxHeapFixedSize(Arrays.copyOf(example, example.length), k));
        // System.out.println("method4_quickselect: " + solver.method4_quickselect(Arrays.copyOf(example, example.length), k));
    }
}
