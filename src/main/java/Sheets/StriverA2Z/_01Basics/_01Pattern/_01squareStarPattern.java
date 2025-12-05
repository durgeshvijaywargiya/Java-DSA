package Sheets.StriverA2Z._01Basics._01Pattern;

public class _01squareStarPattern {

    /**
     * Prints a square pattern of stars of size N x N.
     * Example for N = 5:
     * * * * * *
     * * * * * *
     * * * * * *
     * * * * * *
     * * * * * *
     *
     * @param N the size of the square pattern
     */
    public void pattern1(int N) {
        // Outer loop controls the number of rows
        for (int i = 0; i < N; i++) {

            // Inner loop controls the number of columns for each row
            for (int j = 0; j < N; j++) {
                System.out.print("* ");  // Print star followed by space
            }

            System.out.println();  // Move to next line after each row
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _01squareStarPattern solution = new _01squareStarPattern();

        int N = 5;  // Size of the square pattern

        // Call the method to print the pattern
        solution.pattern1(N);
    }
}
