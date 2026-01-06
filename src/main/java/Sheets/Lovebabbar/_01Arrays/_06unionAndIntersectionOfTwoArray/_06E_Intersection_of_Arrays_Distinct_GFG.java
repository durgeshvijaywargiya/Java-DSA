package Sheets.Lovebabbar._01Arrays._06unionAndIntersectionOfTwoArray;

import java.util.Arrays;
import java.util.HashSet;

public class _06E_Intersection_of_Arrays_Distinct_GFG {

    // -----------------------------------------------------------
    // method1_countOccurrences (YOUR ORIGINAL LOGIC)
    // -----------------------------------------------------------
    /**
     * Counts total number of common elements.
     * Duplicates in second array are counted multiple times.

     * Example:
     * a = [1,2,3], b = [2,2,3] → output = 3

     * Time: O(n + m)
     * Space: O(n)
     */
    public static int method1_countOccurrences(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for (int x : a) set.add(x);

        for (int x : b) {
            if (set.contains(x)) {
                count++;
            }
        }
        return count;
    }

    // -----------------------------------------------------------
    // method2_distinctIntersection (FAANG CLARITY)
    // -----------------------------------------------------------
    /**
     * Counts DISTINCT common elements between two arrays.

     * Example:
     * a = [1,2,3], b = [2,2,3] → output = 2

     * Time: O(n + m)
     * Space: O(n + m)
     */
    public static int method2_distinctIntersection(int[] a, int[] b) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for (int x : a) setA.add(x);
        for (int x : b) {
            if (setA.contains(x)) {
                intersection.add(x);
            }
        }
        return intersection.size();
    }

    // -----------------------------------------------------------
    // method3_sortedTwoPointers (BEST if arrays are sorted)
    // -----------------------------------------------------------
    /**
     * Counts DISTINCT common elements using two pointers.
     * Assumes both arrays are sorted.

     * Time: O(n + m)
     * Space: O(1)
     */
    public static int method3_sortedTwoPointers(int[] a, int[] b) {
        int i = 0, j = 0;
        int count = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                count++;

                int val = a[i];
                while (i < a.length && a[i] == val) i++;
                while (j < b.length && b[j] == val) j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    public static int solution(int[] a, int[] b) {
        return method1_countOccurrences(a, b);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 2, 3, 5};

        System.out.println("Occurrences count: " + solution(a, b));
        System.out.println("Distinct count: " + method2_distinctIntersection(a, b));

        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println("Sorted two-pointer distinct: " +
                method3_sortedTwoPointers(a, b));
    }
}
