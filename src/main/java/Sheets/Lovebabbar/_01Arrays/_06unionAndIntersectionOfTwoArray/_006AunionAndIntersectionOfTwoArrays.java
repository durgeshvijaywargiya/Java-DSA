package Sheets.Lovebabbar._01Arrays._06unionAndIntersectionOfTwoArray;
import java.util.*;
public class _006AunionAndIntersectionOfTwoArrays {

    // -----------------------------------------------------------
    // method1_hashSet (YOUR ORIGINAL APPROACH)
    // -----------------------------------------------------------
    /**
     * Uses HashSet to compute union of two arrays.
     *
     * Time: O(n + m) average
     * Space: O(n + m)
     * Order: NOT preserved
     *
     * Best when arrays are unsorted.
     */
    public static ArrayList<Integer> method1_hashSet(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : a) set.add(x);
        for (int x : b) set.add(x);

        return new ArrayList<>(set);
    }

    // -----------------------------------------------------------
    // method2_sortedTwoPointers (FAANG PREFERRED for sorted arrays)
    // -----------------------------------------------------------
    /**
     * Uses two-pointer technique assuming both arrays are sorted.
     *
     * Time: O(n + m)
     * Space: O(1) extra (excluding output)
     * Order: Preserved (sorted)
     */
    public static ArrayList<Integer> method2_sortedTwoPointers(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        int n = a.length, m = b.length;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                addIfNotDuplicate(result, a[i]);
                i++;
            } else if (a[i] > b[j]) {
                addIfNotDuplicate(result, b[j]);
                j++;
            } else {
                addIfNotDuplicate(result, a[i]);
                i++;
                j++;
            }
        }

        while (i < n) addIfNotDuplicate(result, a[i++]);
        while (j < m) addIfNotDuplicate(result, b[j++]);

        return result;
    }

    private static void addIfNotDuplicate(ArrayList<Integer> list, int value) {
        if (list.isEmpty() || list.get(list.size() - 1) != value) {
            list.add(value);
        }
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    /**
     * Default solution:
     * - Uses HashSet (safe for unsorted arrays)
     */
    public static ArrayList<Integer> solution(int[] a, int[] b) {
        return method1_hashSet(a, b);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 6, 7};

        System.out.println("Union (HashSet): " + solution(a, b));

        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println("Union (Two Pointers): " +
                method2_sortedTwoPointers(a, b));
    }
}

