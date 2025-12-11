package Sheets.StriverA2Z._01Basics._04Basicmath;

public class _02reversenumber_Leetcode {

    // ---------------------------------------------------
    // method1: Original logic (beautified)
    // ---------------------------------------------------
    public int method1_original(int x) {
        int sign = (x >= 0) ? 1 : -1;
        int n = Math.abs(x);
        int result = 0;

        int maxDiv10 = Integer.MAX_VALUE / 10;
        int maxLastDigit = Integer.MAX_VALUE % 10;

        while (n > 0) {
            int digit = n % 10;

            if (result > maxDiv10 || (result == maxDiv10 && digit > maxLastDigit)) {
                return 0;
            }

            result = result * 10 + digit;
            n /= 10;
        }

        return result * sign;
    }

    // ---------------------------------------------------
    // method2: FAANG-standard math reverse (cleanest)
    // ---------------------------------------------------
    public int method2_mathReverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;

            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }

            rev = rev * 10 + digit;
            x /= 10;
        }

        return rev;
    }

    // ---------------------------------------------------
    // method3: Reverse using long for detection
    // ---------------------------------------------------
    public int method3_reverseUsingLong(int x) {
        long rev = 0;

        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) rev;
    }

    // ---------------------------------------------------
    // Recommended solution method (FAANG standard)
    // ---------------------------------------------------
    public int solution(int x) {
        return method2_mathReverse(x);
    }

    // ---------------------------------------------------
    // Demo main
    // ---------------------------------------------------
    public static void main(String[] args) {
        _02reversenumber_Leetcode solver = new _02reversenumber_Leetcode();

        int x = 1534236469;
        System.out.println("Reversed: " + solver.solution(x));
    }
}




