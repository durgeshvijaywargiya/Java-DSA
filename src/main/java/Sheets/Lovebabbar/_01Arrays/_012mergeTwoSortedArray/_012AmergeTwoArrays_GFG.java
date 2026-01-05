package Sheets.Lovebabbar._01Arrays._012mergeTwoSortedArray;
import java.util.Arrays;
public class _012AmergeTwoArrays_GFG {

    // ===========================================================
    // METHOD 1: Swap Largest of a[] with Smallest of b[] + Sort
    // ===========================================================
    /**
     * Your approach:
     * - Compare largest elements of a[] with smallest of b[]
     * - Swap if out of order
     * - Sort both arrays at the end
     *
     * Time Complexity: O((n + m) log(n + m))
     * Space Complexity: O(1)
     *
     * Valid but NOT optimal.
     */
    public void mergeArrays_swapAndSort(int[] a, int[] b) {
        int i = a.length - 1;
        int j = 0;

        while (i >= 0 && j < b.length) {
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    // ===========================================================
    // METHOD 2: GAP METHOD (FAANG PREFERRED & OPTIMAL)
    // ===========================================================
    /**
     * Uses Shell Sort / Gap Method to merge arrays in-place.
     *
     * Time Complexity: O((n + m) log(n + m))
     * Space Complexity: O(1)
     */
    public void mergeArrays_gapMethod(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int gap = nextGap(n + m);

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < n + m) {

                // Case 1: both pointers in array a
                if (i < n && j < n) {
                    if (a[i] > a[j]) {
                        swap(a, i, a, j);
                    }
                }
                // Case 2: i in a[], j in b[]
                else if (i < n && j >= n) {
                    if (a[i] > b[j - n]) {
                        swap(a, i, b, j - n);
                    }
                }
                // Case 3: both pointers in array b
                else {
                    if (b[i - n] > b[j - n]) {
                        swap(b, i - n, b, j - n);
                    }
                }

                i++;
                j++;
            }
            gap = nextGap(gap);
        }
    }

    private int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    private void swap(int[] a, int i, int[] b, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    // ===========================================================
    // Recommended Default (Interview Choice)
    // ===========================================================
    public void solution(int[] a, int[] b) {
        mergeArrays_gapMethod(a, b);
    }

    // ===========================================================
    public static void main(String[] args) {
        _012AmergeTwoArrays_GFG solver =
                new _012AmergeTwoArrays_GFG();

        int[] a = {1, 4, 7, 8, 10};
        int[] b = {2, 3, 9};

        solver.solution(a, b);

        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));
    }
}
