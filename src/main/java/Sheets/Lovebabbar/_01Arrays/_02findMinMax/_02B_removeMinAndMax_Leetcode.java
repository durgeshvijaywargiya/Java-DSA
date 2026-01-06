package Sheets.Lovebabbar._01Arrays._02findMinMax;
import java.util.Arrays;
public class _02B_removeMinAndMax_Leetcode {

    // ===========================================================
    // METHOD 1: Index-based Deletion Calculation (YOUR SOLUTION)
    // ===========================================================
    /**
     * Finds the minimum number of deletions required to remove
     * both the minimum and maximum elements from the array.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Step 1: Find indices of min and max elements
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }

        // Step 2: Compute deletions from different strategies
        int deleteFromFront =
                Math.max(minIndex, maxIndex) + 1;

        int deleteFromBack =
                n - Math.min(minIndex, maxIndex);

        int deleteFromBothSides =
                (Math.min(minIndex, maxIndex) + 1)
                        + (n - Math.max(minIndex, maxIndex));

        // Step 3: Return minimum deletions
        return Math.min(
                deleteFromFront,
                Math.min(deleteFromBack, deleteFromBothSides)
        );
    }

    // ===========================================================
    // METHOD 2: Same Logic with Normalized Indices (Readable Variant)
    // ===========================================================
    /**
     * Same algorithm, slightly clearer by normalizing indices.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int minimumDeletions_normalized(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        int option1 = right + 1;            // remove from front
        int option2 = n - left;             // remove from back
        int option3 = (left + 1) + (n - right); // remove from both sides

        return Math.min(option1, Math.min(option2, option3));
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public int solution(int[] nums) {
        return minimumDeletions(nums);
    }

    // ===========================================================
    public static void main(String[] args) {
        _02B_removeMinAndMax_Leetcode solver =
                new _02B_removeMinAndMax_Leetcode();

        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};

        System.out.println("Array            : " + Arrays.toString(nums));
        System.out.println("Minimum Deletions: " + solver.solution(nums));
    }
}
