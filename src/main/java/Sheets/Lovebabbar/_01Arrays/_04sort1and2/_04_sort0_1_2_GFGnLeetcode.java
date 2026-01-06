package Sheets.Lovebabbar._01Arrays._04sort1and2;
import java.util.Arrays;


public class _04_sort0_1_2_GFGnLeetcode {

    // -----------------------------------------------------------
    // method1_originalArrayBased
    // -----------------------------------------------------------
    public void method1_ArrayBased(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int left = 0, right = arr.length - 1;
        int[] result = new int[arr.length];

        for (int v : arr) {
            if (v == 0) result[left++] = 0;
            else if (v == 2) result[right--] = 2;
        }

        // Step 2: Fill the middle with 1s
        for (int i = left; i <= right; i++) {
            result[i] = 1;
        }

        // Step 3: Copy result back into original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }



    // -----------------------------------------------------------
    // method2_arrayBasedOptimised  (highly reliable)
    // -----------------------------------------------------------


    public void method2_arrayBasedOptimised(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int n = arr.length;
        int left = 0, right = n - 1;
        int[] result = new int[n];

        for (int v : arr) {
            if (v == 0) result[left++] = 0;
            else if (v == 2) result[right--] = 2;
        }

        // Fill middle with 1s
        Arrays.fill(result, left, right + 1, 1);

        System.arraycopy(result, 0, arr, 0, n);
    }

    // -----------------------------------------------------------
    // method3_countingSort  (highly reliable)
    // -----------------------------------------------------------

    public void method3_countingSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int count0 = 0, count1 = 0, count2 = 0;

        for (int v : arr) {
            if (v == 0) count0++;
            else if (v == 1) count1++;
            else count2++;
        }

        int index = 0;

        while (count0-- > 0) arr[index++] = 0;
        while (count1-- > 0) arr[index++] = 1;
        while (count2-- > 0) arr[index++] = 2;
    }

    // -----------------------------------------------------------
    // method3_dutchNationalFlag (BEST)
    // -----------------------------------------------------------
    public void method3_dutchNationalFlag(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // -----------------------------------------------------------
    // Recommended Default: Dutch National Flag
    // -----------------------------------------------------------
    public void solution(int[] arr) {
        method3_dutchNationalFlag(arr);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        _04_sort0_1_2_GFGnLeetcode solver = new _04_sort0_1_2_GFGnLeetcode();

        int[] arr = {2, 0, 1, 2, 0, 1, 1, 0};
        System.out.println("Before: " + Arrays.toString(arr));

        solver.solution(arr);

        System.out.println("After:  " + Arrays.toString(arr));
    }
}

