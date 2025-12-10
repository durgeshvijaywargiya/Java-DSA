package Sheets.StriverA2Z._01Basics._02Pattern;

public class _13increasingNumberTriangle {

    /**
     * Prints a triangle where numbers increase continuously row by row.
     *
     * Example for N = 5:
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     * 11 12 13 14 15
     *
     * @param N the height of the triangle
     */
    public void pattern13(int N) {

        int count = 1;  // Starting number

        // Outer loop controls rows (0 to N-1)
        for (int i = 0; i < N; i++) {

            // Inner loop prints increasing numbers for each row
            for (int j = 0; j <= i; j++) {
                System.out.print(count + " ");
                count++;  // Move to next number
            }

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _13increasingNumberTriangle solution = new _13increasingNumberTriangle();

        int N = 5;  // Height of the triangle

        // Call the method to print the pattern
        solution.pattern13(N);
    }
}
