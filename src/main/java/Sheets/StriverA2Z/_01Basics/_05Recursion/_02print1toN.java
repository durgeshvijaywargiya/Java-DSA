package Sheets.StriverA2Z._01Basics._05Recursion;

public class _02print1toN {

    /**
     * Prints numbers from 1 to N using recursion.
     */
    public void printTillN(int N) {

        // Start recursion from 1
        helper(1, N);
    }

    private void helper(int count, int n) {

        // Print current number
        System.out.print(count + " ");

        // Recursive call until count reaches n
        if (count != n) {
            helper(count + 1, n);
        }
    }

    public static void main(String[] args) {

        _02print1toN solution = new _02print1toN();
        int N = 5;

        solution.printTillN(N);
    }
}

