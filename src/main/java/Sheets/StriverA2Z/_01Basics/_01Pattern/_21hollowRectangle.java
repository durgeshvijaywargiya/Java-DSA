package Sheets.StriverA2Z._01Basics._01Pattern;

public class _21hollowRectangle {

    /**
     * Prints a hollow square/rectangle pattern of stars.
     *
     * Example for N = 5:
     * *****
     * *   *
     * *   *
     * *   *
     * *****
     *
     * ------------------- LOGIC EXPLANATION -------------------
     * We are printing a grid of size N x N.
     *
     * A "hollow rectangle" means:
     *   - All border cells are '*'
     *   - All inner cells are ' '
     *
     * So for any cell (i, j):
     *
     *   If it is on the border:
     *      i == 0          → first row
     *      i == N-1        → last row
     *      j == 0          → first column
     *      j == N-1        → last column
     *
     *   Then print "*"
     *
     *   Otherwise:
     *      print space
     *
     * This creates a perfect hollow box.
     * ---------------------------------------------------------
     */
    public void pattern21(int N) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                // Border check
                if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        _21hollowRectangle solution = new _21hollowRectangle();
        int N = 5;
        solution.pattern21(N);
    }
}
