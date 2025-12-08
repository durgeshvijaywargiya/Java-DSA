package Sheets.StriverA2Z._01Basics._01Pattern;

public class _12numberCrown {
    public void pattern12(int N) {
        // Initial number of spaces in the first row
        int spaces = 2 * (N - 1);

        // Outer loop for the number of rows
        for (int i = 1; i <= N; i++) {

            // Inner loop to print numbers in increasing order
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Inner loop to print spaces in the middle
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // Inner loop to print numbers in decreasing order
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            // Move to the next line after printing the row
            System.out.println();

            // Decrease spaces by 2 after each row
            spaces -= 2;
        }
    }

    public static void main(String[] args) {
        _12numberCrown sol = new _12numberCrown();
        int N = 5;
        sol.pattern12(N); // Call the function to print the pattern
    }
}
