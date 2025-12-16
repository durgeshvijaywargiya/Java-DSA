package Sheets.Lovebabbar._01Arrays;

import java.util.Arrays;

public class _005AmoveNegativeToLeft {

    // -----------------------------------------------------------
    // method1_partitionBased (YOUR ORIGINAL IDEA - IN-PLACE)
    // -----------------------------------------------------------
    /**
     * Moves all negative numbers to the left side of the array.
     * Uses partition logic (similar to QuickSort partition).
     * Time: O(n)
     * Space: O(1)
     * Stable: NO
     */
    public static void method1_partitionBased(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int j = 0; // next position for negative number

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }

    // -----------------------------------------------------------
    // method2_stableUsingExtraArray
    // -----------------------------------------------------------
    /**
     * Stable version using extra array.
     * Time: O(n)
     * Space: O(n)
     * Stable: YES
     */
    public static int[] method2_stableUsingExtraArray(int[] arr) {
        if (arr == null || arr.length == 0) return arr;

        int[] temp = new int[arr.length];
        int idx = 0;

        for (int v : arr) if (v < 0) temp[idx++] = v;
        for (int v : arr) if (v >= 0) temp[idx++] = v;

        return temp;
    }

    // -----------------------------------------------------------
    // Helper swap
    // -----------------------------------------------------------
    private static void swap(int[] a, int i, int j) {
        if (i == j) return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    public static void solution(int[] arr) {
        method1_partitionBased(arr);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        int[] arr = {-12, -13, -5, -7, 5, -3, -6};

        System.out.println("Before: " + Arrays.toString(arr));
        solution(arr);
        System.out.println("After : " + Arrays.toString(arr));

        // Stable version example
        int[] stable = method2_stableUsingExtraArray(arr);
        System.out.println("Stable : " + Arrays.toString(stable));
    }
}
