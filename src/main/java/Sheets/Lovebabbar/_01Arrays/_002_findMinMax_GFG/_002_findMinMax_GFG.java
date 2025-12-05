package Sheets.Lovebabbar._01Arrays._002_findMinMax_GFG;
import java.util.*;
/*
 * Merged class containing multiple methods (method1, method2, method3, method4...).

 * - method1: sort-based (simple but O(n log n))
 * - method2: single-pass scan (idiomatic O(n))
 * - method3: pairwise comparisons (reduces comparisons to ~1.5n)
 * - method4: divide and conquer (recursive)

 * The DEMO_METHOD is "solution" — main() demonstrates calling solution(),
 * which delegates to method2 (single-pass) by default.

 * Assumption: For null/empty arrays we return an empty ArrayList<Integer>.
 */
public class _002_findMinMax_GFG {
    // =========================
    // method1: sort-based
    // When to use: quick to write; not optimal for performance-sensitive code.
    // Time: O(n log n), Space: O(1) extra (plus sorting overhead)
    // =========================
    public ArrayList<Integer> method1_sort(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;

        Arrays.sort(arr);
        result.add(arr[0]);
        result.add(arr[arr.length - 1]);
        return result;
    }

    // =========================
    // method2: single-pass scan (recommended/default)
    // When to use: best balance of simplicity, readability, and performance.
    // Time: O(n), Space: O(1) extra
    // =========================
    public ArrayList<Integer> method2_scan(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;

        int n = arr.length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int v = arr[i];
            if (v < minVal) minVal = v;
            if (v > maxVal) maxVal = v;
        }

        result.add(minVal);
        result.add(maxVal);
        return result;
    }

    // =========================
    // method3: pairwise comparisons (fewer comparisons ~ 3n/2)
    // When to use: when you want to show an optimization reducing comparisons.
    // Time: O(n), Space: O(1) extra, fewer comparisons than naive scan
    // =========================
    public ArrayList<Integer> method3_pairwise(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;

        int n = arr.length;
        int minVal, maxVal;
        int i = 0;

        if (n % 2 == 0) {
            if (arr[0] < arr[1]) {
                minVal = arr[0];
                maxVal = arr[1];
            } else {
                minVal = arr[1];
                maxVal = arr[0];
            }
            i = 2;
        } else {
            minVal = maxVal = arr[0];
            i = 1;
        }

        while (i + 1 < n) {
            int a = arr[i];
            int b = arr[i + 1];
            int localMin, localMax;
            if (a < b) {
                localMin = a;
                localMax = b;
            } else {
                localMin = b;
                localMax = a;
            }
            if (localMin < minVal) minVal = localMin;
            if (localMax > maxVal) maxVal = localMax;
            i += 2;
        }

        result.add(minVal);
        result.add(maxVal);
        return result;
    }

    // =========================
    // method4: divide and conquer (recursive)
    // When to use: demonstrates divide-and-conquer; comparable comparisons to pairwise.
    // Time: O(n), Space: O(log n) recursion stack
    // =========================
    public ArrayList<Integer> method4_divideConquer(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;

        int[] mm = divideConquer(arr, 0, arr.length - 1);
        result.add(mm[0]);
        result.add(mm[1]);
        return result;
    }

    private int[] divideConquer(int[] arr, int left, int right) {
        if (left == right) {
            return new int[] { arr[left], arr[left] };
        }
        if (right == left + 1) {
            if (arr[left] < arr[right]) return new int[] { arr[left], arr[right] };
            else return new int[] { arr[right], arr[left] };
        }
        int mid = left + (right - left) / 2;
        int[] leftMm = divideConquer(arr, left, mid);
        int[] rightMm = divideConquer(arr, mid + 1, right);
        int minVal = Math.min(leftMm[0], rightMm[0]);
        int maxVal = Math.max(leftMm[1], rightMm[1]);
        return new int[] { minVal, maxVal };
    }

    // =========================
    // solution(): DEMO_METHOD
    // Delegates to method2_scan by default (single-pass).
    // Change delegation if you want a different default.
    // =========================
    public ArrayList<Integer> solution(int[] arr) {
        // Default to the idiomatic single-pass scan (method2_scan)
        return method2_scan(arr);
    }

    // Demo main shows usage of DEMO_METHOD "solution"
    public static void main(String[] args) {
        _002_findMinMax_GFG solver = new _002_findMinMax_GFG();

        int[] example = {3, 1, 7, -2, 10, 0};
        System.out.println("Input: " + java.util.Arrays.toString(example));

        ArrayList<Integer> ans = solver.solution(example); // calls method2_scan
        if (ans.isEmpty()) {
            System.out.println("Empty input or null input provided.");
        } else {
            System.out.println("Min: " + ans.get(0) + ", Max: " + ans.get(1));
        }

        // If you want to test other methods, uncomment below:
        // System.out.println("method1_sort: " + solver.method1_sort(example));
        // System.out.println("method3_pairwise: " + solver.method3_pairwise(example));
        // System.out.println("method4_divideConquer: " + solver.method4_divideConquer(example));
    }
}
