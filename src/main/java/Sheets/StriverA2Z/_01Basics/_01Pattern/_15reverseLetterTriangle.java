package Sheets.StriverA2Z._01Basics._01Pattern;

public class _15reverseLetterTriangle {

    /**
     * Prints a reverse (inverted) letter triangle.
     *
     * Example for N = 5:
     * ABCDE
     * ABCD
     * ABC
     * AB
     * A
     *
     * Logic:
     * - ASCII value of 'A' = 65
     * - First row prints N letters starting from A
     * - Next rows reduce by one letter each time
     *
     * @param N the height of the triangle
     */
    public void pattern15(int N) {

        // Outer loop starts from N and decreases to 1 (controls rows)
        for (int i = N; i > 0; i--) {

            // Inner loop prints characters from 'A' up to ('A' + i - 1)
            for (int j = 0; j < i; j++) {
                System.out.print((char)(65 + j));
            }

            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _15reverseLetterTriangle solution = new _15reverseLetterTriangle();

        int N = 5;  // Height of the triangle

        // Call the method to print the pattern
        solution.pattern15(N);
    }
}
