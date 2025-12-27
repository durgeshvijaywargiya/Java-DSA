package Other.Leetcode;

public class _005reverseWordsWithSameVowelCount {

    // ------------------------------------------------------------
    // method1_original
    // ------------------------------------------------------------
    /**
     * SOLUTION IDEA:

     * Problem:
     * - Given a sentence, reverse only those words whose
     *   vowel count is equal to the vowel count of the FIRST word.

     * Steps:
     * 1. Split the sentence into words using space as delimiter.
     * 2. Count vowels in the first word → this becomes the "base".
     * 3. Traverse remaining words:
     *      - If a word has the same vowel count as base,
     *        reverse that word.
     * 4. Join all words back into a single string and return.

     * Example:
     * Input:  "hello apple world again"
     * First word = "hello" → vowel count = 2

     * Word checks:
     * - "apple" → vowels = 2 → reverse → "elppa"
     * - "world" → vowels = 1 → unchanged
     * - "again" → vowels = 3 → unchanged

     * Output:
     * "hello elppa world again"

     * Time Complexity:
     * - O(N * L)
     *   where N = number of words, L = average word length

     * Space Complexity:
     * - O(N) for storing words array
     */
    public static String method1_original(String s) {

        String[] words = s.split(" ");
        int base = countVowels(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (countVowels(words[i]) == base) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }

        return String.join(" ", words);
    }

    // ------------------------------------------------------------
    // method2_microOptimized (DEMO METHOD)
    // ------------------------------------------------------------
    /**
     * SOLUTION IDEA (Micro-Optimized Output Building):

     * This method uses the SAME logic as method1_original,
     * but builds the final result manually using StringBuilder
     * instead of String.join().

     * Why this exists:
     * - Demonstrates manual string construction.
     * - Useful when avoiding helper utilities like String.join().

     * Core logic remains identical:
     * - Identify words with matching vowel count.
     * - Reverse those words.

     * Time Complexity:
     * - O(N * L)

     * Space Complexity:
     * - O(N)
     */
    public static String method2_microOptimized(String s) {

        String[] words = s.split(" ");
        int base = countVowels(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (countVowels(words[i]) == base) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            res.append(words[i]);
            if (i != words.length - 1) res.append(" ");
        }
        return res.toString();
    }

    /**
     * Helper method to count vowels in a given word.

     * Vowels considered:
     * a, e, i, o, u (lowercase only)

     * Time Complexity:
     * - O(L) where L = length of the word
     */
    private static int countVowels(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    // ------------------------------------------------------------
    // main — DEMO
    // ------------------------------------------------------------
    public static void main(String[] args) {
        String s = "hello apple world again";
        System.out.println(method2_microOptimized(s));
    }
}
