package Sheets.StriverA2Z._01Basics._01Pattern;

public class _08invertedStarPyramid {

    /**
     * Prints an inverted star pyramid pattern using absolute-distance logic.
     *
     * Logic (your original logic):
     * - Total columns = 2*N - 1
     * - For each row i:
     *      Compute distance from center column: absolute = j - N
     *      If |absolute| < (N - i) → print "*"
     *      Else → print space
     *
     * This creates an inverted pyramid based on decreasing width.
     *
     * @param N the height of the inverted pyramid
     */
    public void pattern8(int N) {

        // Loop over each row (0 to N-1)
        for (int i = 0; i < N; i++) {

            // Loop over each column (1 to 2*N - 1)
            for (int j = 1; j < (2 * N); j++) {

                // Distance from the center column
                int absolute = j - N;

                // Print "*" when absolute distance is less than (N - i)
                // Otherwise print space
                if (Math.abs(absolute) < (N - i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create instance of this pattern class
        _08invertedStarPyramid solution = new _08invertedStarPyramid();

        int N = 5;  // Height of the pyramid

        // Print the inverted star pyramid
        solution.pattern8(N);
    }
}
