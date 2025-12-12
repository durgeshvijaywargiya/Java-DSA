package Sheets.StriverA2Z._01Basics._04Basicmath;

public class _03palindromenumber_Leetcode_GFG {

        // ------------------------------------------------------------
        // method1_originalLike
        // ------------------------------------------------------------
        /**
         * method1_originalLike
         *
         * Purpose:
         * - Beautified original solution: convert to string and compare characters.
         * - Preserves the behavior of the original code provided (including negatives handled by string).
         *
         * When to use:
         * - To demonstrate the original logic or when string-based checks are acceptable.
         *
         * Time Complexity: O(d)
         * Space Complexity: O(d)
         */
        public static boolean method1_originalLike(int x) {
        if (x == 0) return true;

        String number = Integer.toString(x);
        int length = number.length();
        for (int i = 0; i < (length / 2); i++) {
            if (number.charAt(i) != number.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

        // ------------------------------------------------------------
        // method2_stringBased (DEMO_METHOD)
        // ------------------------------------------------------------
        /**
         * method2_stringBased (DEMO_METHOD)
         *
         * Purpose:
         * - Micro-optimized string-based palindrome check.
         *
         * When to use:
         * - Simple, highly readable solution in non-performance-critical code.
         *
         * Time Complexity: O(d)
         * Space Complexity: O(d)
         */
        public static boolean method2_stringBased(int x) {
        if (x == 0) return true;

        String s = Integer.toString(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

        // ------------------------------------------------------------
        // method3_numericReverse
        // ------------------------------------------------------------
        /**
         * method3_numericReverse
         *
         * Purpose:
         * - Reverse the entire integer numerically and compare to original.
         * - Handles overflow by using long during reversal.
         *
         * When to use:
         * - When you want an arithmetic solution and are okay using a wider type temporarily.
         *
         * Time Complexity: O(d)
         * Space Complexity: O(1)
         */
        public static boolean method3_numericReverse(int x) {
        if (x < 0) return false;

        int original = x;
        long reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            if (reversed > Integer.MAX_VALUE) return false; // overflow can't be equal
            x /= 10;
        }
        return (int) reversed == original;
    }

        // ------------------------------------------------------------
        // method4_reverseHalf
        // ------------------------------------------------------------
        /**
         * method4_reverseHalf
         *
         * Purpose:
         * - Reverse only half the number and compare, avoiding overflow and extra memory.
         *
         * When to use:
         * - Preferred numeric solution in interviews and production.
         *
         * Time Complexity: O(d)
         * Space Complexity: O(1)
         */
        public static boolean method4_reverseHalf(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // If number of digits is odd, discard middle digit from reversedHalf
        return x == reversedHalf || x == reversedHalf / 10;
    }

        // ------------------------------------------------------------
        // method5_compareDigitsUsingPower
        // ------------------------------------------------------------
        /**
         * method5_compareDigitsUsingPower
         *
         * Purpose:
         * - Extract and compare leading and trailing digits using powers of 10.
         *
         * When to use:
         * - When you want a numeric comparison approach without reversing digits.
         *
         * Time Complexity: O(d)
         * Space Complexity: O(1)
         */
        public static boolean method5_compareDigitsUsingPower(int x) {
        if (x < 0) return false;
        if (x <= 9) return true;

        int power = 1;
        int temp = x;
        while (temp >= 10) {
            temp /= 10;
            power *= 10;
        }

        while (x != 0) {
            int leading = x / power;
            int trailing = x % 10;
            if (leading != trailing) return false;

            // strip leading and trailing digits
            x = (x % power) / 10;
            power /= 100;
        }

        return true;
    }

        // ------------------------------------------------------------
        // main: Demonstrate ONLY the DEMO_METHOD (method2_stringBased)
        // ------------------------------------------------------------
        public static void main(String[] args) {
        // Test values for demonstration (including edge cases)
        int[] tests = {
                0,
                7,
                -7,
                121,
                -121,
                10,
                1221,
                12321,
                123321,
                Integer.MAX_VALUE,  // 2147483647 -> not palindrome
                2147447412         // example palindrome within int range
        };

        System.out.println("Demonstrating method2_stringBased (DEMO_METHOD):");
        for (int n : tests) {
            boolean res = method2_stringBased(n);
            System.out.printf("n = %d -> isPalindrome = %b%n", n, res);
        }

        // Other methods are available for manual testing:
        // method1_originalLike(n);
        // method3_numericReverse(n);
        // method4_reverseHalf(n);
        // method5_compareDigitsUsingPower(n);
    }
}
