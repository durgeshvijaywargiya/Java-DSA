package Sheets.StriverA2Z._01Basics._01Pattern;

public class _22numberPattern {

    /**
     * Prints a concentric square number pattern of size (2*N - 1) x (2*N - 1).
     *
     * Example for N = 4:
     *
     * 4444444
     * 4333334
     * 4322234
     * 4321234
     * 4322234
     * 4333334
     * 4444444
     *
     * Each "layer" going inwards decreases the number by 1.
     * Outer layer = N, next = N-1, ..., center = 1.
     *
     * ---------------------------------------------------------
     * DETAILED LOGIC EXPLANATION (for future you)
     * ---------------------------------------------------------
     * 1) Grid size:
     *      length = 2*N - 1
     *      For N = 4 → length = 7 → a 7x7 matrix
     *
     * 2) We create a 2D matrix:
     *      int[][] matrix = new int[length][length];
     *
     *    By default, all values are 0.
     *
     * 3) We fill the matrix layer by layer from outer to inner:
     *
     *      value starts at N and goes down to 1.
     *
     *      For each layer i:
     *          - top row index    = i
     *          - bottom row index = length - i - 1
     *          - left col index   = i
     *          - right col index  = length - i - 1
     *
     *      So, for layer i, the "border" cells are:
     *          j == i                (top row)
     *          j == length - i - 1   (bottom row)
     *          k == i                (left column)
     *          k == length - i - 1   (right column)
     *
     * 4) Triple loop:
     *
     *      for (int i = 0; i < N; i++) {          // each layer
     *          for (int j = i; j < length - i; j++) {      // row index in current layer
     *              for (int k = i; k < length - i; k++) {  // column index in current layer
     *
     *                  if (j == i || j == length - i - 1 ||
     *                      k == i || k == length - i - 1) {
     *
     *                      matrix[j][k] = value;
     *                  }
     *              }
     *          }
     *          value--;   // next inner layer will have smaller value
     *      }
     *
     *    This means:
     *      - For i = 0 → outermost border gets N
     *      - For i = 1 → next inner border gets N-1
     *      - ...
     *      - For i = N-1 → center cell becomes 1
     *
     * 5) Finally, we print the matrix as it is.
     * ---------------------------------------------------------
     */
    public void pattern22(int N) {

        int length = 2 * N - 1;          // Size of the matrix (rows and cols)
        int value = N;                   // Current number to fill the border with

        int[][] matrix = new int[length][length];  // All initialized to 0 by default

        // Fill each "layer" of the matrix from outermost to innermost
        for (int i = 0; i < N; i++) {

            // Rows for this layer go from i to (length - i - 1)
            for (int j = i; j < (length - i); j++) {

                // Columns for this layer go from i to (length - i - 1)
                for (int k = i; k < (length - i); k++) {

                    // If current cell is on the border of this layer, set it to 'value'
                    if (j == i || j == length - i - 1 || k == i || k == length - i - 1) {
                        matrix[j][k] = value;
                    }
                }
            }

            // Decrease value for the next inner layer
            value--;
        }

        // Print the filled matrix
        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }
    }




    public void pattern22alter(int N) {

        int length = 2 * N - 1;  // Total rows and columns

        // Traverse each cell directly and print value based on its position
        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length; j++) {

                // Distance from current cell to each of the 4 borders
                int topDist    = i;
                int leftDist   = j;
                int bottomDist = length - 1 - i;
                int rightDist  = length - 1 - j;

                // Minimum distance to any border
                int minDistToBorder = Math.min(
                        Math.min(topDist, bottomDist),
                        Math.min(leftDist, rightDist)
                );

                // Value = N at outermost layer, then N-1, ..., 1 at center
                int value = N - minDistToBorder;

                System.out.print(value);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        _22numberPattern solution = new _22numberPattern();
        int N = 9;
        solution.pattern22(N);
    }
}
