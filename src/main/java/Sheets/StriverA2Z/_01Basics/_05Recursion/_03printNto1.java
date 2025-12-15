package Sheets.StriverA2Z._01Basics._05Recursion;

public class _03printNto1 {

    /**
     * Prints numbers from N to 1 using recursion.
     */
    void printNos(int n) {

        // Base case: stop recursion
        if (n < 1) {
            return;
        }

        // Print current number
        System.out.print(n + " ");

        // Recursive call with n - 1
        printNos(n - 1);
    }

    public static void main(String[] args) {

        _03printNto1 solution = new _03printNto1();
        int N = 5;

        solution.printNos(N);
    }
}



