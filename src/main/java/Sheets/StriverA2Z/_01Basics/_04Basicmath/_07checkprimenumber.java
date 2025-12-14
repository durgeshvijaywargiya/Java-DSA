package Sheets.StriverA2Z._01Basics._04Basicmath;

public class _07checkprimenumber {

    // ------------------------------------------------------------
    // method1_original
    // Basic trial division
    // Steps:
    // 1. Handle n <= 1 (not prime)
    // 2. Try all i from 2 to sqrt(n)
    // 3. If any divisor found → not prime
    // 4. Otherwise prime
    // ------------------------------------------------------------
    public static boolean method1_original(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {  // check divisors until sqrt(n)
            if (n % i == 0) return false;  // divisor found → composite
        }
        return true;                      // no divisors → prime
    }

    // ------------------------------------------------------------
    // method2_microOptimized
    // Optimized trial division
    // Steps:
    // 1. Handle small edge cases
    // 2. Eliminate all even numbers (>2)
    // 3. Check only odd i from 3 to sqrt(n)
    // Why faster:
    // - Skips half the checks (even numbers)
    // ------------------------------------------------------------
    public static boolean method2_microOptimized(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;          // only even prime
        if (n % 2 == 0) return false;     // even and >2 → not prime

        for (int i = 3; i * i <= n; i += 2) {  // skip evens
            if (n % i == 0) return false;
        }
        return true;
    }

    // ------------------------------------------------------------
    // method3_isPrime6k   (DEMO_METHOD)
    // 6k ± 1 optimization
    // Key observations:
    // - All primes > 3 are in the form 6k-1 or 6k+1
    // Steps:
    // 1. Handle small numbers and eliminate multiples of 2 & 3
    // 2. Check only numbers of form 6k-1 and 6k+1 up to sqrt(n)
    // Why faster:
    // - Reduces checks by ~67%
    // ------------------------------------------------------------
    public static boolean method3_isPrime6k(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;                // 2 and 3 are prime

        if (n % 2 == 0 || n % 3 == 0) return false; // remove multiples of 2 & 3

        // check i = 5, 11, 17... (6k-1) and i+2 = 7, 13, 19... (6k+1)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    // ------------------------------------------------------------
    // method4_MillerRabin
    // Deterministic Miller–Rabin for 32-bit integers
    // Steps:
    // 1. Remove small primes
    // 2. Express n-1 as d * 2^s (factor out powers of 2)
    // 3. Test a few known bases (2,7,61) → deterministic for int range
    // 4. Run "witness test" using modular exponentiation
    // Why FAANG-level:
    // - Much faster: O(log n)
    // - Works for very large numbers accurately
    // ------------------------------------------------------------
    public static boolean method4_MillerRabin(int n) {
        if (n < 2) return false;

        // Fast check small primes
        for (int p : new int[]{2, 3, 5, 7, 11}) {
            if (n == p) return true;
            if (n % p == 0) return n == p;
        }

        // Write n-1 = d * 2^s
        int d = n - 1, s = 0;
        while ((d & 1) == 0) {
            d >>= 1;
            s++;
        }

        // Testing bases guaranteed for 32-bit numbers
        int[] bases = {2, 7, 61};

        for (int a : bases) {
            if (a % n == 0) continue;

            long x = modPow(a, d, n);       // compute a^d % n

            if (x == 1 || x == n - 1) continue;

            boolean composite = true;
            for (int r = 1; r < s; r++) {
                x = (x * x) % n;           // repeat squaring
                if (x == n - 1) {          // n-1 means strong probable prime
                    composite = false;
                    break;
                }
            }
            if (composite) return false;   // proved composite
        }

        return true;  // passed all checks → prime
    }

    // Helper: fast modular exponentiation
    private static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;

            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // ------------------------------------------------------------
    // main: demo method (6k ± 1 fastest simple version)
    // ------------------------------------------------------------
    public static void main(String[] args) {

        int[] tests = {1, 2, 3, 4, 5, 17, 25, 97, 9973, 2147483647};

        System.out.println("DEMO_METHOD: method3_isPrime6k");

        for (int n : tests) {
            System.out.printf("%d → %b\n", n, method3_isPrime6k(n));
        }
    }
}
