package Sheets.StriverA2Z._01Basics._01Pattern;

public class _10halfStarpattern {

    /**
     * Prints a half-diamond type star pattern using your custom logic.
     *
     * Logic:
     * 1. Loop runs from 1 to (2*N - 1)
     * 2. First half (i < N):
     *      - Compute absolute distance from the center: absolute = N - j
     *      - If |absolute| > (N - i), print "*"
     *
     * 3. Second half (i >= N):
     *      - If j > (i - N - 1), print "*"
     *
     * NOTE:
     * - You intentionally do NOT print spaces for the false conditions.
     * - This logic is kept exactly as you wrote it.
     */
    public void pattern10(int N) {

        // Loop from 1 to (2*N - 1)
        for (int i = 1; i < 2 * N; i++) {

            // Upper half logic
            if (i < N) {

                for (int j = 0; j < N; j++) {

                    int absolute = N - j;

                    // Print star when condition matches your logic
                    if (Math.abs(absolute) > (N - i)) {
                        System.out.print("*");
                    }
                }
            }

            // Lower half logic
            else {

                for (int j = 0; j < N; j++) {

                    // Print star when condition matches your logic
                    if (j > (i - N - 1)) {
                        System.out.print("*");
                    }
                }
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        _10halfStarpattern solution = new _10halfStarpattern();

        int N = 5; // Number of rows for upper half

        solution.pattern10(N);
    }
}
