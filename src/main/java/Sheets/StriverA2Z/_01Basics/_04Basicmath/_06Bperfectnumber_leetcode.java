package Sheets.StriverA2Z._01Basics._04Basicmath;
import java.util.*;

public class _06Bperfectnumber_leetcode {

    // ----------------------------------------------
    // method1_original  → basic divisor collection
    // ----------------------------------------------
    public static boolean method1_original(int num) {

        if (num <= 1) return false;

        int sum = 0;
        ArrayList<Integer> div = divisors(num);

        for (int x : div) sum += x;
        sum -= num;

        return sum == num;
    }

    private static ArrayList<Integer> divisors(int n) {
        ArrayList<Integer> out = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();

        int limit = (int) Math.sqrt(n);

        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {

                out.add(i);

                int pair = n / i;
                if (pair != i) {
                    large.add(pair);
                }
            }
        }
        out.addAll(large);
        return out;
    }

    // ----------------------------------------------
    // method2_microOptimized (DEMO)
    // ----------------------------------------------
    public static boolean method2_microOptimized(int num) {

        if (num <= 1) return false;

        int sum = 1;
        int limit = (int) Math.sqrt(num);

        for (int i = 2; i <= limit; i++) {

            if (num % i == 0) {
                sum += i;

                int pair = num / i;
                if (pair != i) sum += pair;
            }
        }
        return sum == num;
    }

    // ----------------------------------------------
    // main() — DEMO
    // ----------------------------------------------
    public static void main(String[] args) {

        int[] tests = {6, 28, 496, 8128, 12, 97, 33550336};

        System.out.println("DEMO METHOD: method2_microOptimized");
        for (int n : tests) {
            System.out.printf("%d → %b\n", n, method2_microOptimized(n));
        }
    }
}

