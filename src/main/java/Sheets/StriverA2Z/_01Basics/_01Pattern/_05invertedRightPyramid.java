package Sheets.StriverA2Z._01Basics._01Pattern;

public class _05invertedRightPyramid {

    /**
     * Prints an inverted right-angled star pyramid.
     *
     * Example for N = 5:
     * * * * * *
     * * * * *
     * * * *
     * * *
     * *
     *
     * @param N the number of rows in the pyramid
     */
    public void pattern5(int N) {

        // Outer loop starts from N and decreases to 1 (for each row)
        for (int i = N; i > 0; i--) {

            // Inner loop prints 'i' stars for the current row
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }

            // Move to the next line after printing the row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _05invertedRightPyramid solution = new _05invertedRightPyramid();

        int N = 5;  // Number of rows for the pattern

        // Call the method to print the pattern
        solution.pattern5(N);
    }
}
