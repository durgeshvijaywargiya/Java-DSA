package Sheets.StriverA2Z._01Basics._02Pattern;

public class _17alphaHill {

    /**
     * Prints an Alphabet Hill Pattern (Pyramid with letters).
     *
     * Example for N = 5:
     *     A
     *    ABA
     *   ABCBA
     *  ABCDCBA
     * ABCDEDCBA
     *
     * Logic Breakdown:
     * ----------------------------------------------------------------------
     * 1) Total columns = 2*N - 1
     *    - For N = 5 → 9 columns (a symmetric center)
     *
     * 2) We use "absolute distance from center" logic:
     *      absolute = j - N
     *      |absolute| gives how far a column is from the middle.
     *
     * 3) Printing rule:
     *      If |absolute| > i (row number):
     *            → Outside the pyramid → Print " "
     *      Else:
     *            → Inside the pyramid → Print a letter
     *
     * 4) Letter logic:
     *      Left side letters increase, right side letters decrease.
     *
     *      Character printed = (char)(65 + i - |absolute|)
     *
     *      Why this works:
     *      - At center (absolute = 0): 65 + i → gives A, B, C, ...
     *        Example row 3 → center = 'D'
     *
     *      - As you move away from center:
     *            |absolute| becomes 1, 2, 3...
     *            So letter = center letter - distance
     *
     *      This automatically produces patterns like:
     *          A
     *          ABA
     *          ABCBA
     *          ABCDCBA
     * ----------------------------------------------------------------------
     *
     * @param N height of the pattern
     */
    public void pattern17(int N) {

        // Loop for each row (0 to N-1)
        for (int i = 0; i < N; i++) {

            // Loop for each column (1 to 2*N - 1)
            for (int j = 1; j < (2 * N); j++) {

                // Distance of current column from center
                int absolute = j - N;

                // If |distance| is outside allowed range for this row, print space
                if (Math.abs(absolute) > i) {
                    System.out.print(" ");
                }
                // Otherwise print the correct letter
                else {
                    System.out.print((char)(65 + i - Math.abs(absolute)));
                }
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        _17alphaHill solution = new _17alphaHill();

        int N = 4;  // Height of the alpha hill

        solution.pattern17(N);
    }
}
