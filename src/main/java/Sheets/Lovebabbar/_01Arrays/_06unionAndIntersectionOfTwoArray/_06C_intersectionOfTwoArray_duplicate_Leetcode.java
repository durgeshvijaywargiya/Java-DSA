package Sheets.Lovebabbar._01Arrays._06unionAndIntersectionOfTwoArray;
import java.util.*;
public class _06C_intersectionOfTwoArray_duplicate_Leetcode {

    // ===========================================================
    // METHOD 1: ArrayList-based (YOUR ORIGINAL APPROACH)
    // ===========================================================
    /**
     * Uses ArrayList and linear search.
     *
     * Time Complexity: O(n * m)  -> can cause TLE
     * Space Complexity: O(n)
     *
     * Included for learning and comparison.
     */
    public int[] intersect_arrayList(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums1) {
            list.add(x);
        }

        List<Integer> result = new ArrayList<>();
        for (int x : nums2) {
            if (list.contains(x)) {
                list.remove(Integer.valueOf(x));
                result.add(x);
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    // ===========================================================
    // METHOD 2: HashMap Frequency Count (OPTIMAL / FAANG STANDARD)
    // ===========================================================
    /**
     * Uses HashMap to count frequencies.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(min(n, m))
     */
    public int[] intersect_hashMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int x : nums2) {
            if (freq.containsKey(x) && freq.get(x) > 0) {
                result.add(x);
                freq.put(x, freq.get(x) - 1);
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    // ===========================================================
    // METHOD 3: Sorting + Two Pointers (NO HASHMAP)
    // ===========================================================
    /**
     * Sort both arrays and use two pointers.
     *
     * Time Complexity: O(n log n + m log m)
     * Space Complexity: O(1) (excluding output)
     */
    public int[] intersect_twoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
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
    // Recommended Default
    // ===========================================================
    public int[] solution(int[] nums1, int[] nums2) {
        return intersect_hashMap(nums1, nums2);
    }

    // ===========================================================
    public static void main(String[] args) {
        _06C_intersectionOfTwoArray_duplicate_Leetcode solver =
                new _06C_intersectionOfTwoArray_duplicate_Leetcode();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println("Intersection: " +
                Arrays.toString(solver.solution(nums1, nums2)));
    }
}
