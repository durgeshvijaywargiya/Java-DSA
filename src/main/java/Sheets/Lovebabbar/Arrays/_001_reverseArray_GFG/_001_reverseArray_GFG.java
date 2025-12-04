package Sheets.Lovebabbar.Arrays._001_reverseArray_GFG;
import java.util.Arrays;
public class _001_reverseArray_GFG {
    /**
     * Approach 1: In-place reversal using a for-loop swapping symmetric indices.
     * Keeps the original logic you wrote but with defensive null check and comments.

     * Time: O(n), Space: O(1)

     * Example usage:
     *   reverseArray1(arr); // arr is reversed in-place
     */
    public void reverseArray1(int[] arr) {
        if (arr == null) return; // defensive: nothing to do

        // swap elements from ends to the middle
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    /**
     * Approach 2: In-place reversal using two pointers (idiomatic).
     * This caches the length once and uses i,j pointers to make intent clear.

     * Time: O(n), Space: O(1)

     * This is the method demonstrated in main().
     */
    public void reverseArray2(int[] arr) {
        if (arr == null) return;

        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    /**
     * Approach 3: Non-mutating approach that returns a new reversed array.
     * Use this when you need to keep the original array unchanged (immutability).

     * Time: O(n), Space: O(n)

     * Example usage:
     *   int[] reversed = reverseArray3(original);
     */
    public int[] reverseArray3(int[] arr) {
        if (arr == null) return null;

        int n = arr.length;
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            out[i] = arr[n - 1 - i];
        }
        return out;
    }

    /**
     * Demo main — uses reverseArray2 to reverse and print an example array.
     * You can call reverseArray1 or reverseArray3 manually to test them.
     */
    public static void main(String[] args) {
        _001_reverseArray_GFG sol = new _001_reverseArray_GFG();

        int[] a = {1, 2, 3, 4, 5};
        System.out.println("Original: " + Arrays.toString(a));

        // Demonstration: use reverseArray2 (in-place two-pointer)
        sol.reverseArray2(a);
        System.out.println("Reversed (reverseArray2): " + Arrays.toString(a));

    }
}

