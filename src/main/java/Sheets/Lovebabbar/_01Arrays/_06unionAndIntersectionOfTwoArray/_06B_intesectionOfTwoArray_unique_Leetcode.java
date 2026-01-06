package Sheets.Lovebabbar._01Arrays._06unionAndIntersectionOfTwoArray;
import java.util.*;
public class _06B_intesectionOfTwoArray_unique_Leetcode {

    // ===========================================================
    // METHOD 1: HashSet (YOUR APPROACH - CLEANED)
    // ===========================================================
    /**
     * Uses HashSet to store unique elements.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     */
    public int[] intersection_hashSet(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
        }

        Set<Integer> result = new HashSet<>();
        for (int x : nums2) {
            if (set.contains(x)) {
                result.add(x);
            }
        }

        int[] ans = new int[result.size()];
        int i = 0;
        for (int x : result) {
            ans[i++] = x;
        }
        return ans;
    }

    // ===========================================================
    // METHOD 2: Sorting + Two Pointers (FROM SCRATCH, INTERVIEW-STRONG)
    // ===========================================================
    /**
     * Sort both arrays and use two pointers.
     * Avoids hash-based collections.
     *
     * Time Complexity: O(n log n + m log m)
     * Space Complexity: O(1) (excluding output)
     */
    public int[] intersection_twoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // Avoid duplicates
                if (result.isEmpty() || result.get(result.size() - 1) != nums1[i]) {
                    result.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }
        return ans;
    }

    // ===========================================================
    // METHOD 3: Boolean Array (MOST OPTIMIZED WHEN RANGE IS SMALL)
    // ===========================================================
    /**
     * Uses boolean array instead of HashSet.
     *
     * Constraint-based optimization.
     * nums[i] in range [0, 1000]
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1) (constant 1001 size)
     */
    public int[] intersection_booleanArray(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[1001];

        for (int x : nums1) {
            seen[x] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int x : nums2) {
            if (seen[x]) {
                result.add(x);
                seen[x] = false; // ensure uniqueness
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    // ===========================================================
    // Recommended Default (FAANG SAFE)
    // ===========================================================
    public int[] solution(int[] nums1, int[] nums2) {
        return intersection_twoPointers(nums1, nums2);
    }

    // ===========================================================
    public static void main(String[] args) {
        _06B_intesectionOfTwoArray_unique_Leetcode solver =
                new _06B_intesectionOfTwoArray_unique_Leetcode();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println("Intersection: " +
                Arrays.toString(solver.solution(nums1, nums2)));
    }
}
