package Sheets.StriverA2Z._01Basics._01Pattern;

public class _09diamondStarPyramid {

    /**
     * Prints a diamond star pattern using two different logic sections:
     *
     * Part 1 (i < N):
     *  - Builds the upper half of the diamond.
     *  - For each column j:
     *        absolute = N - j
     *        If |absolute| > i → print space
     *        Else → print star
     *
     * Part 2 (i >= N):
     *  - Builds the lower half of the diamond.
     *  - For each column k:
     *        absolute = N - k
     *        If |absolute| < (N - i%5) → print star
     *        Else → print space
     *
     * @param N defines height of upper half of the diamond
     */
    public void pattern09(int N) {

        // Loop from 0 to 2*N - 1 (full diamond height)
        for (int i = 0; i < 2 * N; i++) {

            // Upper half of diamond
            if (i < N) {

                // Loop through columns for upper part
                for (int j = 1; j < 2 * N; j++) {

                    // Distance from center
                    int absolute = N - j;

                    // Print based on absolute distance condition
                    if (Math.abs(absolute) > i) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }
            }

            // Lower half of diamond
            else {

                // Loop through columns for lower part
                for (int k = 1; k < 2 * N; k++) {

                    // Distance from center
                    int absolute = N - k;

                    // Print based on your custom lower-half condition
                    if (Math.abs(absolute) < (N - i % 5)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String args[]) {

        // Create object instance
        _09diamondStarPyramid solution = new _09diamondStarPyramid();

        int N = 5; // Diamond upper-half height

        // Call the pattern printer
        solution.pattern09(N);
    }
}
