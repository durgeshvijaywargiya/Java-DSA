package Sheets.StriverA2Z._01Basics._05Recursion;

public class _06reverseArrayUsingRecursion {

    /**
     * Reverses an array using recursion.
     *
     * Logic:
     * - Swap first and last elements
     * - Move inward by increasing start and decreasing end
     * - Stop when start > end
     */
    public void reverseArray(int arr[]) {

        helper(0, arr.length - 1, arr);
    }

    private void helper(int start, int end, int array[]) {

        // Base case: when pointers cross
        if (start > end) {
            return;
        }

        // Swap elements
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        // Recursive call with smaller subproblem
        helper(start + 1, end - 1, array);
    }

    public static void main(String[] args) {

        _06reverseArrayUsingRecursion solution = new _06reverseArrayUsingRecursion();

        int[] arr = {1, 2, 3, 4, 5};
        solution.reverseArray(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
