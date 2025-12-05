package Sheets.StriverA2Z._01Basics._01Pattern;

public class _06invertedNumberedPyramid {

    /**
     * Prints an inverted numbered right-angled pyramid.
     *
     * Example for N = 5:
     * 12345
     * 1234
     * 123
     * 12
     * 1
     *
     * @param N the height of the pyramid
     */
    public void pattern6(int N) {

        // Outer loop starts from N and goes down to 1 (controls rows)
        for (int i = N; i > 0; i--) {

            // Inner loop prints numbers from 1 to i for each row
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _06invertedNumberedPyramid solution = new _06invertedNumberedPyramid();

        int N = 5;  // Height of the inverted pyramid

        // Call the method to print the pattern
        solution.pattern6(N);
    }
}
