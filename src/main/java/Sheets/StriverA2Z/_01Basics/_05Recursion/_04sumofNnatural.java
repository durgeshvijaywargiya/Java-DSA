package Sheets.StriverA2Z._01Basics._05Recursion;

public class _04sumofNnatural {

    /**
     * Returns the sum of first N natural numbers using recursion.
     */
    public static int findSum(int N) {

        // Base case
        if (N == 1) {
            return 1;
        }

        // Recursive case
        return N + findSum(N - 1);
    }

    public static void main(String[] args) {

        int N = 5;
        int result = findSum(N);

        System.out.println(result);
    }
}




