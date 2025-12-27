package Sheets.Lovebabbar._01Arrays._09minimiseTheHeight;

import java.util.Arrays;

public class _09BminimiseHeight_cannotBeNegative {

    // ===========================================================
    // APPROACH: Greedy + Sorting (OPTIMAL)
    // ===========================================================
    /**
     * Returns the minimum possible difference between the tallest and
     * shortest towers after increasing or decreasing each height by k.

     * NOTE:
     * - Each tower must be modified exactly once
     * - Resulting heights must be non-negative

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

        // Step 2: Try all valid partitions
        for (int i = 0; i < n - 1; i++) {

            int minHeight = Math.min(arr[0] + k, arr[i + 1] - k);
            int maxHeight = Math.max(arr[n - 1] - k, arr[i] + k);

            // Skip invalid cases (negative height not allowed)
            if (minHeight < 0) continue;

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
        _09BminimiseHeight_cannotBeNegative solver =
                new _09BminimiseHeight_cannotBeNegative();

        int[] arr = {3, 9, 12, 16, 20};
        int k = 3;

        System.out.println("Minimum Difference = " +
                solver.solution(arr, k));
    }
}
