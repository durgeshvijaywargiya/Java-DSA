package Other.Leetcode;

public class _011excelSheetColumnTitle {

    // ===========================================================
    // APPROACH: Modified Base-26 Conversion (OPTIMAL)
    // ===========================================================
    /**
     * Converts a positive integer into its corresponding Excel column title.

     * Time Complexity: O(log₍₂₆₎ n)
     * Space Complexity: O(log₍₂₆₎ n)
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // crucial adjustment for 1-based indexing
            result.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public String solution(int columnNumber) {
        return convertToTitle(columnNumber);
    }

    // ===========================================================
    public static void main(String[] args) {
        _011excelSheetColumnTitle solver =
                new _011excelSheetColumnTitle();

        int columnNumber = 28;
        System.out.println("Column Number : " + columnNumber);
        System.out.println("Excel Title   : " + solver.solution(columnNumber));
    }
}

