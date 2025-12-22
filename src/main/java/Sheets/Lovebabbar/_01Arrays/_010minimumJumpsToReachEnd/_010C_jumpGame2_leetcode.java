package Sheets.Lovebabbar._01Arrays._010minimumJumpsToReachEnd;
import java.util.Arrays;
public class _010C_jumpGame2_leetcode {

    // ===========================================================
    // APPROACH: Single-Pass Greedy (YOUR SOLUTION - OPTIMAL)
    // ===========================================================
    /**
     * Returns the minimum number of jumps needed to reach the last index.

     * Greedy idea:
     * - Each jump covers a range of indices
     * - Expand the range as far as possible
     * - When the current range ends, a jump is mandatory

     * Time: O(n)
     * Space: O(1)
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        int jumps = 0;
        int currentEnd = 0;  // end of current jump range
        int farthest = 0;    // farthest reachable index

        // We don't need to jump from the last index
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // When current range is exhausted, take a jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public int solution(int[] nums) {
        return jump(nums);
    }

    // ===========================================================
    public static void main(String[] args) {
        _010C_jumpGame2_leetcode solver = new _010C_jumpGame2_leetcode();

        int[] nums = {2, 3, 1, 1, 4};

        System.out.println("Array      : " + Arrays.toString(nums));
        System.out.println("Min Jumps  : " + solver.solution(nums));
    }
}
