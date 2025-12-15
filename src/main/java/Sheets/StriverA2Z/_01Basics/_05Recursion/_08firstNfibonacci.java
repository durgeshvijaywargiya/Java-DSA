package Sheets.StriverA2Z._01Basics._05Recursion;

public class _08firstNfibonacci {
    /**
     * Returns an array containing the first n Fibonacci numbers.
     *
     * Fibonacci sequence:
     * 0, 1, 1, 2, 3, 5, 8, ...
     */
    public int[] fibonacciNumbers(int n) {

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = fib(i);
        }

        return array;
    }

    private int fib(int n) {

        // Base cases
        if (n <= 0) return 0;
        if (n == 1) return 1;

        // Recursive case
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {

        _08firstNfibonacci solution = new _08firstNfibonacci();

        int n = 7;
        int[] result = solution.fibonacciNumbers(n);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
