package Sheets.StriverA2Z._01Basics._01Pattern;

public class _20symmetricButterflyPattern {

    /**
     * Prints a symmetric butterfly pattern using spacing controlled by:
     *
     *  Top half:
     *      Left  stars  = i
     *      Middle spaces = (N - i) * 2 spaces
     *      Right stars  = i
     *
     *  Bottom half:
     *      Left stars   = 2*N - i
     *      Middle spaces = (i - N) * 2 spaces
     *      Right stars  = 2*N - i
     *
     * Example (N = 5):
     *
     * *        *
     * **      **
     * ***    ***
     * ****  ****
     * **********
     * ****  ****
     * ***    ***
     * **      **
     * *        *
     *
     * -------------------------------------------------------------
     * DETAILED LOGIC EXPLANATION (for future reference)
     * -------------------------------------------------------------
     *
     * 1. Total rows = (2*N - 1)
     *
     *    For N = 5 → 9 rows
     *
     * 2. For row i (top half: i = 1..N):
     *
     *      i = row number (1-based)
     *
     *      Left stars  = i
     *      Middle spaces = (N - i) → but you print **two spaces** `"  "`
     *                        so the visual width matches the pattern symmetry.
     *
     *      Right stars = i
     *
     *    Example NC = 5:
     *    i = 1 → 1 star, (5-1)=4 gaps, 1 star
     *    i = 2 → 2 stars, 3 gaps, 2 stars
     *    ...
     *
     * 3. Bottom half symmetry (i = N+1 .. 2*N-1)
     *
     *      stars = (2*N - i)
     *      spaces = (i - N)
     *
     *      Example for N = 5:
     *      i = 6 → stars=4, spaces=1
     *      i = 7 → stars=3, spaces=2
     *      ...
     *
     * This perfectly mirrors the top half.
     *
     */
    public void pattern20(int N) {

        // Loop over (2*N - 1) rows
        for (int i = 1; i < 2 * N; i++) {

            // ------------------ TOP HALF ------------------
            if (i <= N) {

                // Left stars: i stars
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }

                // Middle double-spaces: (N - i)
                for (int j = 0; j < (N - i); j++) {
                    System.out.print("  ");  // 2-space
                }

                // Right stars: i stars
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
            }

            // ------------------ BOTTOM HALF ------------------
            else {

                // Number of stars decreases: (2*N - i)
                int stars = 2 * N - i;

                // Left stars
                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }

                // Middle spaces: (i - N)
                for (int j = 0; j < (i - N); j++) {
                    System.out.print("  ");
                }

                // Right stars
                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }
            }

            // New row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        _20symmetricButterflyPattern solution = new _20symmetricButterflyPattern();
        int N = 5;
        solution.pattern20(N);
    }
}
