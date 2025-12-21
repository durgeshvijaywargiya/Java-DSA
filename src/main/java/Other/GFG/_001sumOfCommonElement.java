package Other.GFG;
import java.util.Arrays;
import java.util.HashSet;
public class _001sumOfCommonElement {

    private static final int MOD = 1_000_000_007;

    // -----------------------------------------------------------
    // method1_hashSetRemove (YOUR ORIGINAL - BEST)
    // -----------------------------------------------------------
    /**
     * Sums UNIQUE common elements between two arrays.
     *
     * Approach:
     * - Store elements of arr1 in a HashSet
     * - Traverse arr2
     * - If element exists in set:
     *     add to sum
     *     remove from set (to avoid duplicates)
     *
     * Time: O(n1 + n2)
     * Space: O(n1)
     */
    public static int method1_hashSetRemove(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;

        for (int x : arr1) set.add(x);

        for (int x : arr2) {
            if (set.contains(x)) {
                sum = (sum + x) % MOD;
                set.remove(x); // ensure uniqueness
            }
        }
        return (int) sum;
    }

    // -----------------------------------------------------------
    // method2_sortedTwoPointers (if arrays are sorted)
    // -----------------------------------------------------------
    /**
     * Two-pointer solution assuming both arrays are sorted.
     *
     * Time: O(n1 + n2)
     * Space: O(1)
     */
    public static int method2_sortedTwoPointers(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;
        long sum = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                sum = (sum + arr1[i]) % MOD;

                int val = arr1[i];
                while (i < arr1.length && arr1[i] == val) i++;
                while (j < arr2.length && arr2[j] == val) j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return (int) sum;
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    public static int solution(int[] arr1, int[] arr2) {
        return method1_hashSetRemove(arr1, arr2);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 3, 5};

        System.out.println("Sum of common elements: " +
                solution(arr1, arr2));
    }
}
