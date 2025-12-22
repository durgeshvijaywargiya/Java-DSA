package Sheets.Lovebabbar._01Arrays._010minimumJumpsToReachEnd;
import java.util.Arrays;


public class _010B_jumpGame_leetcode {

    // ===========================================================
    // APPROACH 1: Backward Greedy (YOUR SOLUTION - FAANG PREFERRED)
    // ===========================================================
    /**
     * Checks if last index is reachable from index 0.

     * Idea:
     * - Start from the last index
     * - Move backwards
     * - Track the leftmost index that can reach the end

     * Time: O(n)
     * Space: O(1)
     */
    public boolean canJump_backwardGreedy(int[] nums) {
        if (nums == null || nums.length <= 1) return true;

        int lastGoodIndex = nums.length - 1;

        // Traverse from right to left
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }

        return lastGoodIndex == 0;
    }

    // ===========================================================
    // APPROACH 2: Forward Greedy (Also FAANG ACCEPTABLE)
    // ===========================================================
    /**
     * Tracks the farthest index reachable while moving forward.

     * Time: O(n)
     * Space: O(1)
     */
    public boolean canJump_forwardGreedy(int[] nums) {
        if (nums == null || nums.length <= 1) return true;

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false; // cannot reach this index
            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }

    // ===========================================================
    // Recommended Default (Clean Interview Choice)
    // ===========================================================
    public boolean solution(int[] nums) {
        return canJump_backwardGreedy(nums);
    }

    // ===========================================================
    public static void main(String[] args) {
        _010B_jumpGame_leetcode solver = new _010B_jumpGame_leetcode();

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Can Jump: " + solver.solution(nums1));

        System.out.println("Array 2: " + Arrays.toString(nums2));
        System.out.println("Can Jump: " + solver.solution(nums2));
    }
}
