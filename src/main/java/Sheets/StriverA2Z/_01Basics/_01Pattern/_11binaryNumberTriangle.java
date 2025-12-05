package Sheets.StriverA2Z._01Basics._01Pattern;

public class _11binaryNumberTriangle {

    /**
     * Prints a binary number triangle pattern.
     *
     * Logic:
     * - For even row index (i % 2 == 0):
     *      Print (j + 1) % 2
     *      → Produces pattern: 1 0 1 0 ...
     *
     * - For odd row index (i % 2 == 1):
     *      Print j % 2
     *      → Produces pattern: 0 1 0 1 ...
     *
     * Pattern example for N = 5:
     * 1
     * 01
     * 101
     * 0101
     * 10101
     *
     * @param N height of the triangle
     */
    public void pattern11(int N) {

        // Loop through N rows
        for (int i = 0; i < N; i++) {

            // Loop through columns for each row
            for (int j = 0; j <= i; j++) {

                // If row index is odd
                if (i % 2 == 1) {
                    System.out.print(j % 2);      // Print j mod 2
                }
                // If row index is even
                else {
                    System.out.print((j + 1) % 2); // Print (j+1) mod 2
                }
            }

            // Next line after finishing each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        _11binaryNumberTriangle solution = new _11binaryNumberTriangle();

        int N = 5; // Height of pattern

        solution.pattern11(N);
    }
}
