package Sheets.Lovebabbar._01Arrays._014mergeInterval;
import java.util.*;
public class _014_mergeInterval_GFGnLeetcode {

    // ===========================================================
    // METHOD 1: Greedy with List (RECOMMENDED / FAANG STANDARD)
    // ===========================================================
    /**
     * Merges overlapping intervals using sorting + greedy scan.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public int[][] merge_greedyList(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        // Step 2: Merge overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                merged.add(prev);
                prev = curr;
            }
        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }

    // ===========================================================
    // METHOD 2: In-place Merge using Index Pointer (Optimized)
    // ===========================================================
    /**
     * Merges intervals in-place using array manipulation.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) (excluding sorting)
     */
    public int[][] merge_inPlace(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int k = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[k][1] >= intervals[i][0]) {
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            } else {
                k++;
                intervals[k] = intervals[i];
            }
        }

        return Arrays.copyOfRange(intervals, 0, k + 1);
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public int[][] solution(int[][] intervals) {
        return merge_greedyList(intervals);
    }

    // ===========================================================
    public static void main(String[] args) {
        _014_mergeInterval_GFGnLeetcode solver =
                new _014_mergeInterval_GFGnLeetcode();

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        int[][] result = solver.solution(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
