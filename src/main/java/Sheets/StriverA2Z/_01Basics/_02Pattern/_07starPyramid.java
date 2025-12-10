package Sheets.StriverA2Z._01Basics._02Pattern;

public class _07starPyramid {

    /**
     * Prints a centered star pyramid of height N.
     *
     * Example for N = 5:
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     *
     * Logic:
     * - Total columns = 2*N - 1
     * - For each row (i):
     *      Print spaces where |j - N| > i
     *      Print stars   where |j - N| <= i
     *
     * @param N the height of the pyramid
     */
    public void pattern7(int N) {

        // Loop for each row (0 to N-1)
        for (int i = 0; i < N; i++) {

            // Loop across columns: from 1 to 2*N - 1
            for (int j = 1; j < (2 * N); j++) {

                // Distance of current column j from the center column N
                int absolute = j - N;

                // If the distance is greater than row number => print space
                if (Math.abs(absolute) > i) {
                    System.out.print(" ");
                }
                // Otherwise print the star
                else {
                    System.out.print("*");
                }
            }

            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _07starPyramid solution = new _07starPyramid();

        int N = 5;  // Height of the pyramid (very large output)

        // Call method to print the pyramid
        solution.pattern7(N);
    }
}
