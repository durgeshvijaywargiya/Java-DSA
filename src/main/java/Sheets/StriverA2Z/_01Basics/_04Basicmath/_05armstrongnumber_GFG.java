package Sheets.StriverA2Z._01Basics._04Basicmath;

public class _05armstrongnumber_GFG {

    // ------------------------------------------------------------
    // method1_original3Digit (original logic)
    // ------------------------------------------------------------
    public static boolean method1_original3Digit(int n) {
        if (n == 0) return true;

        int temp = n;
        int sum = 0;

        while (temp > 0) {
            int d = temp % 10;
            sum += d * d * d; // cube only
            temp /= 10;
        }

        return sum == n;
    }


    // ------------------------------------------------------------
    // method2_armstrongGeneralSafe (no floating-point)
    // ------------------------------------------------------------
    public static boolean method2_armstrongGeneralSafe(int n) {
        if (n == 0) return true;

        int temp = n;
        int digits = 0;

        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = n;
        long sum = 0;

        while (temp > 0) {
            int digit = temp % 10;

            long powered = 1;
            for (int i = 0; i < digits; i++) {
                powered *= digit;
            }

            sum += powered;
            temp /= 10;
        }

        return sum == n;
    }


    // ------------------------------------------------------------
    // method3_armstrongLookup
    // ------------------------------------------------------------
    private static final int[] ARMSTRONG_INT = {
            0, 1, 153, 370, 371, 407,
            1634, 8208, 9474,
            54748, 92727, 93084,
            548834
    };

    public static boolean method3_armstrongLookup(int n) {
        for (int x : ARMSTRONG_INT) {
            if (x == n) return true;
        }
        return false;
    }

    // ------------------------------------------------------------
    // main() — runs DEMO_METHOD only
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] tests = {0, 1, 153, 370, 371, 9474, 548834, 100, 200, 9475};

        System.out.println("DEMO_METHOD: method3_armstrongGeneral()");

        for (int n : tests) {
            System.out.printf("n = %d → Armstrong = %b\n",
                    n, method2_armstrongGeneralSafe(n));
        }
    }
}


