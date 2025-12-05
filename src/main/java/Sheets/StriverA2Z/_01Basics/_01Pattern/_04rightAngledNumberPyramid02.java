package Sheets.StriverA2Z._01Basics._01Pattern;

public class _04rightAngledNumberPyramid02 {

    /**
     * Prints a right-angled number pyramid where each row contains
     * the same repeated number equal to the row index.
     *
     * Example for N = 5:
     * 1
     * 2 2
     * 3 3 3
     * 4 4 4 4
     * 5 5 5 5 5
     *
     * @param N the height of the pyramid
     */
    public void pattern4(int N) {

        // Outer loop controls the number of rows
        for (int i = 1; i <= N; i++) {

            // Inner loop prints the current row number 'i', i times
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }

            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _04rightAngledNumberPyramid02 solution = new _04rightAngledNumberPyramid02();

        int N = 5;  // Height of the number pyramid

        // Call the method to print the pattern
        solution.pattern4(N);
    }
}
