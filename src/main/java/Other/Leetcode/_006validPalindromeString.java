package Other.Leetcode;

public class _006validPalindromeString {

    // ------------------------------------------------------------
    // method1_twoPointer (BEST / DEMO METHOD)
    // ------------------------------------------------------------
    /**
     * Problem:
     * - Determine if a string is a palindrome considering:
     *      ✔ only alphanumeric characters
     *      ✔ case-insensitive comparison

     * Steps:
     * 1. Use two pointers:
     *      - left  → start of string
     *      - right → end of string

     * 2. While left < right:
     *      - Skip non-alphanumeric characters from both ends.
     *      - Compare characters after converting both to lowercase.
     *      - If mismatch found → return false.

     * 3. If all valid characters match → return true.

     * Time Complexity:
     * - O(N) → each character is visited at most once
     * Space Complexity:
     * - O(1) → no extra space used

     * Why this is BEST:
     * - No extra memory
     * - Single pass
     * - Optimal for large strings
     */
    public static boolean method1_twoPointer(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            // Skip non-alphanumeric characters from left
            if (!Character.isLetterOrDigit(l)) {
                left++;

                // Skip non-alphanumeric characters from right
            } else if (!Character.isLetterOrDigit(r)) {
                right--;

                // Compare valid characters
            } else {
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    // ------------------------------------------------------------
    // method2_preprocess
    // ------------------------------------------------------------
    /**
     * SOLUTION IDEA (Preprocessing + Palindrome Check):

     * Steps:
     * 1. Build a cleaned string:
     *      - Keep only alphanumeric characters.
     *      - Convert all characters to lowercase.

     * 2. Check if the cleaned string is a palindrome
     *    using a simple two-pointer or loop approach.


     * Time Complexity:
     * - O(N)
     * Space Complexity:
     * - O(N) → extra space for cleaned string
     * Drawback:
     * - Uses extra memory compared to two-pointer approach.
     */
    public static boolean method2_preprocess(String s) {

        StringBuilder sb = new StringBuilder(s.length());

        // Preprocess: remove non-alphanumeric characters and lowercase
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        // Palindrome check on cleaned string
        int len = sb.length();
        for (int i = 0; i < len / 2; i++) {
            if (sb.charAt(i) != sb.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    // ------------------------------------------------------------
    // main — DEMO
    // ------------------------------------------------------------
    public static void main(String[] args) {

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println("DEMO METHOD: method1_twoPointer");
        System.out.println(method1_twoPointer(s1)); // true
        System.out.println(method1_twoPointer(s2)); // false
    }
}
