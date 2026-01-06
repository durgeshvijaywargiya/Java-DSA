package Sheets.Lovebabbar._01Arrays._06unionAndIntersectionOfTwoArray;
import java.util.*;
public class _06D_basedOnIntersection_Leetcode {

    // ===========================================================
    // METHOD 1: Your Original Approach (Cleaned)
    // ===========================================================
    /**
     * Uses two HashSets.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     */
    public int[] findIntersectionValues_original(int[] nums1, int[] nums2) {
        int[] ans = new int[2];

        Set<Integer> set1 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }

        Set<Integer> common = new HashSet<>();
        for (int x : nums2) {
            if (set1.contains(x)) {
                common.add(x);
            }
        }

        for (int x : nums1) {
            if (common.contains(x)) ans[0]++;
        }

        for (int x : nums2) {
            if (common.contains(x)) ans[1]++;
        }

        return ans;
    }

    // ===========================================================
    // METHOD 2: Optimized HashSet (SINGLE SET – PREFERRED)
    // ===========================================================
    /**
     * Uses only one HashSet.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n)
     */
    public int[] findIntersectionValues_hashSet(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
        }

        int count1 = 0;
        int count2 = 0;

        for (int x : nums2) {
            if (set.contains(x)) {
                count2++;
            }
        }

        Set<Integer> nums2Set = new HashSet<>();
        for (int x : nums2) {
            nums2Set.add(x);
        }

        for (int x : nums1) {
            if (nums2Set.contains(x)) {
                count1++;
            }
        }

        return new int[]{count1, count2};
    }

    // ===========================================================
    // METHOD 3: Frequency Array (MOST OPTIMIZED – CONSTRAINT BASED)
    // ===========================================================
    /**
     * Uses boolean arrays instead of HashSet.
     *
     * Constraint: 1 <= nums[i] <= 100
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public int[] findIntersectionValues_frequency(int[] nums1, int[] nums2) {
        boolean[] seen1 = new boolean[101];
        boolean[] seen2 = new boolean[101];

        for (int x : nums1) seen1[x] = true;
        for (int x : nums2) seen2[x] = true;

        int count1 = 0, count2 = 0;

        for (int x : nums1) {
            if (seen2[x]) count1++;
        }

        for (int x : nums2) {
            if (seen1[x]) count2++;
        }

        return new int[]{count1, count2};
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public int[] solution(int[] nums1, int[] nums2) {
        return findIntersectionValues_frequency(nums1, nums2);
    }

    // ===========================================================
    public static void main(String[] args) {
        _06D_basedOnIntersection_Leetcode solver =
                new _06D_basedOnIntersection_Leetcode();

        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2};

        System.out.println("Answer: " +
                Arrays.toString(solver.solution(nums1, nums2)));
    }
}
