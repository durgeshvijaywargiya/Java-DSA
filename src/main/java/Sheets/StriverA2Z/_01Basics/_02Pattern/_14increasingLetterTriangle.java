package Sheets.StriverA2Z._01Basics._02Pattern;

public class _14increasingLetterTriangle {

    /**
     * Prints a triangle of increasing letters starting from 'A'.
     *
     * Example for N = 5:
     * A
     * AB
     * ABC
     * ABCD
     * ABCDE
     *
     * Logic:
     * - ASCII value of 'A' = 65
     * - For each row i, print characters from 'A' to ('A' + i)
     *
     * @param N the height of the letter triangle
     */
    public void pattern14(int N) {

        // Outer loop controls the rows (0 to N-1)
        for (int i = 0; i < N; i++) {

            // Inner loop prints characters starting from A up to A+i
            for (int j = 0; j <= i; j++) {
                System.out.print((char)(65 + j));
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _14increasingLetterTriangle solution = new _14increasingLetterTriangle();

        int N = 5;  // Height of the letter triangle

        // Call the method to print the pattern
        solution.pattern14(N);
    }
}
