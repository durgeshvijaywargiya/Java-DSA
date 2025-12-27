package Other.Leetcode;
import java.util.*;

public class _010singleNumber {

    // ===========================================================
    // APPROACH 1: XOR Bit Manipulation (OPTIMAL & FAANG PREFERRED)
    // ===========================================================
    /**
     * Uses XOR property to find the single number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int singleNumber_xor(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // ===========================================================
    // APPROACH 2: HashMap Frequency Counting (Baseline)
    // ===========================================================
    /**
     * Uses HashMap to count frequency of each number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int singleNumber_hashMap(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0; // unreachable as per problem constraints
    }

    // ===========================================================
    // Recommended Default (Interview Choice)
    // ===========================================================
    public int solution(int[] nums) {
        return singleNumber_xor(nums);
    }

    // ===========================================================
    public static void main(String[] args) {
        _010singleNumber solver = new _010singleNumber();

        int[] nums = {4, 1, 2, 1, 2};

        System.out.println("Single Number = " + solver.solution(nums));
    }
}

