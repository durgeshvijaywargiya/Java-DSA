package Sheets.StriverA2Z._01Basics._01Pattern;

public class _03rightAngledNumberPyramid01 {

    /**
     * Prints a right-angled number pyramid.
     *
     * Example for N = 5:
     * 1
     * 1 2
     * 1 2 3
     * 1 2 3 4
     * 1 2 3 4 5
     *
     * @param N the height of the pyramid
     */
    public void pattern3(int N) {

        // Outer loop controls the number of rows
        for (int i = 1; i <= N; i++) {

            // Inner loop prints numbers from 1 to i for each row
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            // Move to next line after printing each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _03rightAngledNumberPyramid01 solution = new _03rightAngledNumberPyramid01();

        int N = 5;  // Height of the number pyramid

        // Call the method to print the pattern
        solution.pattern3(N);
    }
}
