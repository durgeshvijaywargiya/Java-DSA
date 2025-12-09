package Sheets.StriverA2Z._01Basics._01Pattern;

public class _18alphaTriangle {

    /**
     * Prints an alphabet triangle where each row starts from a decreasing letter
     * and increases to the right.
     *
     * Example for N = 5:
     *
     * E
     * DE
     * CDE
     * BCDE
     * ABCDE
     *
     * --------------------- LOGIC EXPLANATION ---------------------
     *
     * 1) top = 65 + N - 1
     *    - 65 → ASCII value of 'A'
     *    - For N = 5 → top = 65 + 4 = 69 → 'E'
     *
     *    So the first row starts at 'E'
     *
     * 2) For each row i:
     *      Starting letter = (top - i)
     *
     *    Row i = 0 → start at 'E'
     *    Row i = 1 → start at 'D'
     *    Row i = 2 → start at 'C'
     *    ...
     *
     * 3) Inner loop (j from 0 to i):
     *      Each next character is + j offset from the starting letter.
     *
     *      Printed character = (char)(top - i + j)
     *
     * 4) This naturally creates:
     *
     *     i = 0 → print: E
     *     i = 1 → print: D E
     *     i = 2 → print: C D E
     *     i = 3 → print: B C D E
     *     i = 4 → print: A B C D E
     *
     * -------------------------------------------------------------
     *
     * @param N number of rows in the triangle
     */
    public void patter18(int N) {

        int top = 65 + N - 1;  // ASCII of last starting letter (e.g., 'E' for N=5)

        // Loop for each row
        for (int i = 0; i < N; i++) {

            // Print characters from (top - i) to (top - i + i)
            for (int j = 0; j <= i; j++) {

                System.out.print((char)(top - i + j));
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        _18alphaTriangle solution = new _18alphaTriangle();

        int N = 5;
        solution.patter18(N);
    }
}
