package Sheets.StriverA2Z._01Basics._06Hashing;
import java.util.HashMap;
import java.util.Map;

public class _002countElementWithMaxFrequencies {

    // ------------------------------------------------------------
    // method1_singlePass
    // ------------------------------------------------------------
    public static int method1_singlePass(int[] nums) {
        int[] freq = new int[100];

        for (int x : nums) {
            freq[x - 1]++;
        }

        int maxFreq = 0;
        int result = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                result += maxFreq;
            } else if (f > maxFreq) {
                maxFreq = f;
                result = maxFreq;
            }
        }

        return result;
    }

    // ------------------------------------------------------------
    // method2_twoPass (DEMO METHOD)
    // ------------------------------------------------------------
    public static int method2_twoPass(int[] nums) {
        int[] freq = new int[100];

        for (int x : nums) {
            freq[x - 1]++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int count = 0;
        for (int f : freq) {
            if (f == maxFreq) count++;
        }

        return count * maxFreq;
    }

    // ------------------------------------------------------------
    // method3_hashMap
    // ------------------------------------------------------------
    public static int method3_hashMap(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int maxFreq = 0;
        for (int f : freq.values()) {
            maxFreq = Math.max(maxFreq, f);
        }

        int result = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) result += f;
        }

        return result;
    }

    // ------------------------------------------------------------
    // main — DEMO
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4};

        System.out.println("DEMO METHOD: method2_twoPass");
        System.out.println(method2_twoPass(nums)); // Expected: 4
    }
}



