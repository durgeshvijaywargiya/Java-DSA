package Sheets.Lovebabbar._01Arrays._010minimumJumpsToReachEnd;
import java.util.*;

public class _010A_minmumRequiredToReachEnd_GFG {

    // ===========================================================
    // APPROACH 1: Greedy + Reachability Check (YOUR SOLUTION)
    // ===========================================================
    /**
     * Uses two-step approach:
     * 1) Check if end is reachable (Jump Game I logic)
     * 2) Count minimum jumps using greedy range expansion

     * Time: O(n)
     * Space: O(1)
     */
    public int minJumps_withReachCheck(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        // Step 1: Reachability check
        if (!canReach(nums)) return -1;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Step 2: Count minimum jumps
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                currentEnd = farthest;
                jumps++;
            }
        }
        return jumps;
    }

    /**
     * Jump Game I logic to check reachability
     */
    private boolean canReach(int[] nums) {
        int lastGoodIndex = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        return lastGoodIndex == 0;
    }

    // ===========================================================
    // APPROACH 2: Single-Pass Greedy (FAANG PREFERRED)
    // ===========================================================
    /**
     * Single-pass greedy solution.
     * Detects unreachable cases while counting jumps.

     * Time: O(n)
     * Space: O(1)
     */
    public int minJumps_singlePass(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // If we have exhausted the current jump range
            if (i == currentEnd) {

                // Cannot move further -> unreachable
                if (farthest <= i) return -1;

                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

    // ===========================================================
    // Recommended Default (FAANG Style)
    // ===========================================================
    public int solution(int[] nums) {
        return minJumps_singlePass(nums);
    }

    // ===========================================================
    public static void main(String[] args) {
        _010A_minmumRequiredToReachEnd_GFG solver =
                new _010A_minmumRequiredToReachEnd_GFG();

        int[] nums = {2, 3, 1, 1, 4};

        System.out.println("Array          : " + Arrays.toString(nums));
        System.out.println("Min jumps (SP) : " + solver.solution(nums));
        System.out.println("Min jumps (RC) : " + solver.minJumps_withReachCheck(nums));
    }
}

