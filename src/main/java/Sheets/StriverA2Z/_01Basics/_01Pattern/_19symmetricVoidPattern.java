package Sheets.StriverA2Z._01Basics._01Pattern;

public class _19symmetricVoidPattern {

    /**
     * Prints a symmetric void (hollow hourglass-like) star pattern.
     *
     * Example for N = 5:
     * **********
     * ****  ****
     * ***    ***
     * **      **
     * *        *
     * *        *
     * **      **
     * ***    ***
     * ****  ****
     * **********
     *
     * Logic:
     * - Total rows = 2 * N
     * - We maintain:
     *      - Left stars
     *      - Middle spaces (variable 'spaces')
     *      - Right stars (same count as left)
     *
     * - Top half (i <= N):
     *      Left stars  : (N - i + 1)
     *      Spaces      : starts from 0, increases by 2 each row
     *      Right stars : (N - i + 1)
     *
     * - Bottom half (i > N):
     *      Left stars  : (i - N)
     *      Spaces      : decreases by 2 each row (mirrors top)
     *      Right stars : (i - N)
     */
    public void pattern19(int N) {

        int spaces = 0;  // Middle gap between left and right stars

        // Loop over 2*N rows
        for (int i = 1; i <= 2 * N; i++) {

            // Top half (including middle row)
            if (i <= N) {

                // Left stars: from (N - i) down to 0 → gives (N - i + 1) stars
                for (int j = N - i; j >= 0; j--) {
                    System.out.print("*");
                }

                // Middle spaces
                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }

                // Increase spaces by 2 for the next row
                spaces += 2;

                // Right stars: same as left side
                for (int j = N - i; j >= 0; j--) {
                    System.out.print("*");
                }
            }

            // Bottom half
            else {

                // Decrease spaces FIRST to mirror top part
                spaces -= 2;

                // Left stars: count = i - N
                for (int j = i - N; j > 0; j--) {
                    System.out.print("*");
                }

                // Middle spaces (using updated 'spaces')
                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }

                // Right stars: same as left
                for (int j = i - N; j > 0; j--) {
                    System.out.print("*");
                }
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        _19symmetricVoidPattern solution = new _19symmetricVoidPattern();
        int N = 5;
        solution.pattern19(N);
    }
}
