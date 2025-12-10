package Sheets.StriverA2Z._01Basics._02Pattern;

public class _16alphaRamp {

    /**
     * Prints an alphabet ramp pattern where each row contains the
     * same letter repeated, and the letter increases in each row.
     *
     * Example for N = 5:
     * A
     * BB
     * CCC
     * DDDD
     * EEEEE
     *
     * Logic:
     * - ASCII value of 'A' = 65
     * - For row i, print the character (A + i), repeated (i + 1) times
     *
     * @param N the height of the alphabet ramp
     */
    public void pattern16(int N) {

        // Outer loop controls rows (0 to N-1)
        for (int i = 0; i < N; i++) {

            // Inner loop prints the same letter (A + i), (i + 1) times
            for (int j = 0; j <= i; j++) {
                System.out.print((char)(65 + i));
            }

            // Move to next line after printing each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _16alphaRamp solution = new _16alphaRamp();

        int N = 5;  // Height of the letter ramp

        // Call the method to print the pattern
        solution.pattern16(N);
    }
}
