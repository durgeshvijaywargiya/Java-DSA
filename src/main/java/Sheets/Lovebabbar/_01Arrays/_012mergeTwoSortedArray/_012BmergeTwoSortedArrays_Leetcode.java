package Sheets.Lovebabbar._01Arrays._012mergeTwoSortedArray;
import java.util.Arrays;

public class _012BmergeTwoSortedArrays_Leetcode {

    // ===========================================================
    // APPROACH: Three-Pointer In-Place Merge (OPTIMAL)
    // ===========================================================
    /**
     * Merges nums2 into nums1 in-place.
     *
     * nums1 has length m + n, where first m elements are valid.
     * nums2 has n valid elements.
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for the last position in nums1
        int writeIndex = m + n - 1;

        // Merge from the back to avoid overwriting nums1 elements
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[writeIndex--] = nums1[m - 1];
                m--;
            } else {
                nums1[writeIndex--] = nums2[n - 1];
                n--;
            }
        }

        // If nums2 still has elements, copy them
        while (n > 0) {
            nums1[writeIndex--] = nums2[n - 1];
            n--;
        }
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public void solution(int[] nums1, int m, int[] nums2, int n) {
        merge(nums1, m, nums2, n);
    }

    // ===========================================================
    public static void main(String[] args) {
        _012BmergeTwoSortedArrays_Leetcode solver =
                new _012BmergeTwoSortedArrays_Leetcode();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        solver.solution(nums1, 3, nums2, 3);

        System.out.println("Merged Array: " + Arrays.toString(nums1));
    }
}
