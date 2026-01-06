package Sheets.Lovebabbar._01Arrays._05moveNegativeLeftToRight;

import java.util.Arrays;

public class _05B_moveNegativeElementToRightSameOrder_GFG {

    // -----------------------------------------------------------
    // method1_twoEndedStableFill (YOUR ORIGINAL LOGIC)
    // -----------------------------------------------------------
    /**
     * Moves all negative elements to the right side of the array
     * while preserving the relative order of both positives and negatives.
     * Approach:
     * - Fill positives from left
     * - Fill negatives from right (scanning input from right)
     * Time: O(n)
     * Space: O(n)
     * Stable: YES
     */
    public void method1_twoEndedStableFill(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int n = arr.length;
        int pos = 0;
        int neg = n - 1;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            // place positives in forward order
            if (arr[i] >= 0) {
                result[pos++] = arr[i];
            }
            // place negatives in reverse scan but reverse fill → order preserved
            if (arr[n - 1 - i] < 0) {
                result[neg--] = arr[n - 1 - i];
            }
        }

        System.arraycopy(result, 0, arr, 0, n);
    }

    // -----------------------------------------------------------
    // method2_twoPassStable (simpler & more readable)
    // -----------------------------------------------------------
    /**
     * Stable two-pass solution.
     * First copy positives, then negatives.
     * Time: O(n)
     * Space: O(n)
     * Stable: YES
     */
    public void method2_twoPassStable(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int[] result = new int[arr.length];
        int idx = 0;

        for (int v : arr) if (v >= 0) result[idx++] = v;
        for (int v : arr) if (v < 0) result[idx++] = v;

        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    public void solution(int[] arr) {
        method1_twoEndedStableFill(arr);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        _05B_moveNegativeElementToRightSameOrder_GFG solver =
                new _05B_moveNegativeElementToRightSameOrder_GFG();

        int[] arr = {-1, 3, -2, 4, -5, 6};
        System.out.println("Before: " + Arrays.toString(arr));

        solver.solution(arr);

        System.out.println("After : " + Arrays.toString(arr));
    }
}
