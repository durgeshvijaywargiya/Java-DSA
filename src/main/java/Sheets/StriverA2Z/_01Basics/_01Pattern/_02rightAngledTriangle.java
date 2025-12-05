package Sheets.StriverA2Z._01Basics._01Pattern;

public class _02rightAngledTriangle {

    /**
     * Prints a right-angled triangle star pattern.
     *
     * Example for N = 5:
     * *
     * * *
     * * * *
     * * * * *
     * * * * * *
     *
     * @param N the height of the triangle
     */
    public void pattern2(int N) {

        // Outer loop controls the number of rows
        for (int i = 0; i < N; i++) {

            // Inner loop prints stars for the current row (row index + 1 stars)
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            // Move to next line after printing each row
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create an instance of the pattern class
        _02rightAngledTriangle solution = new _02rightAngledTriangle();

        int N = 5;  // Height of the triangle

        // Call the method to print the pattern
        solution.pattern2(N);
    }
}
