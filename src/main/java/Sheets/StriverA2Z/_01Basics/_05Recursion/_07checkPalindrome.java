package Sheets.StriverA2Z._01Basics._05Recursion;

public class _07checkPalindrome {
    /**
     * Checks whether a string is a palindrome using recursion.
     *
     * Palindrome:
     * A string that reads the same forward and backward.
     */
    boolean isPalindrome(String s) {

        return helper(0, s.length() - 1, s);
    }

    private boolean helper(int start, int end, String str) {

        // Base case: crossed pointers means palindrome
        if (start >= end) {
            return true;
        }

        // If characters don't match, not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Check inner substring
        return helper(start + 1, end - 1, str);
    }

    public static void main(String[] args) {

        _07checkPalindrome solution = new _07checkPalindrome();

        String s = "madam";
        System.out.println(solution.isPalindrome(s)); // true
    }
}
