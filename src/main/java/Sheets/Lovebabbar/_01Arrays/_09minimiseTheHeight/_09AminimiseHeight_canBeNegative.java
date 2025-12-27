package Sheets.Lovebabbar._01Arrays._09minimiseTheHeight;

import java.util.Arrays;

public class _09AminimiseHeight_canBeNegative {

    // ===========================================================
    // APPROACH: Greedy + Sorting (OPTIMAL)
    // ===========================================================
    /**
     * Returns the minimum possible difference between the tallest and
     * shortest towers after increasing or decreasing each height by k.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) (ignoring sorting space)
     */
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Initial difference without modification
        int answer = arr[n - 1] - arr[0];

        // Step 2: Try all possible partitions
        for (int i = 0; i < n - 1; i++) {

            int minHeight = Math.min(arr[0] + k, arr[i + 1] - k);
            int maxHeight = Math.max(arr[n - 1] - k, arr[i] + k);

            answer = Math.min(answer, maxHeight - minHeight);
        }
        return answer;
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public int solution(int[] arr, int k) {
        return getMinDiff(arr, k);
    }

    // ===========================================================
    public static void main(String[] args) {
        _09AminimiseHeight_canBeNegative solver =
                new _09AminimiseHeight_canBeNegative();

        int[] arr = {1, 5, 8, 10};
        int k = 2;

        System.out.println("Minimum Difference = " +
                solver.solution(arr, k));
    }
}

