package Sheets.StriverA2Z._01Basics._05Recursion;

public class _05factorial {

    /**
     * Calculates factorial of a number using recursion.
     *
     * Factorial definition:
     * N! = N × (N-1) × (N-2) × ... × 1
     *
     * Base cases:
     * - If N <= 0 → return 1 (by definition)
     * - If N == 1 → return 1
     *
     * Recursive case:
     * - N * factorial(N - 1)
     */
    int factorial(int N) {

        // Base cases
        if (N == 1 || N <= 0) {
            return 1;
        }

        // Recursive case
        return N * factorial(N - 1);
    }

    public static void main(String[] args) {

        _05factorial solution = new _05factorial();
        int N = 5;

        int result = solution.factorial(N);
        System.out.println(result); // Output: 120
    }
}


