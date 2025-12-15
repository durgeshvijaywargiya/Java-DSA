package Sheets.StriverA2Z._01Basics._05Recursion;

public class _01printNamesNtimes {

    /**
     * Prints the string "GFG " exactly N times using recursion.
     */
    void printGfg(int N) {

        // Base case: stop recursion
        if (N == 0) {
            return;
        }

        // Print current "GFG "
        System.out.print("GFG ");

        // Recursive call with N - 1
        printGfg(N - 1);
    }

    public static void main(String[] args) {

        _01printNamesNtimes solution = new _01printNamesNtimes();
        int N = 5;

        solution.printGfg(N);
    }
}
