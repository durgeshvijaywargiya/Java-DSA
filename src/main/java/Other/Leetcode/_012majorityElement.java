package Other.Leetcode;
import java.util.*;
public class _012majorityElement {

    // ===========================================================
    // METHOD 1: Boyer–Moore Voting Algorithm (OPTIMAL & FAANG PREFERRED)
    // ===========================================================
    /**
     * Finds the majority element using Boyer–Moore Voting Algorithm.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int majorityElement_boyerMoore(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate; // guaranteed to exist
    }

    // ===========================================================
    // METHOD 2: HashMap Frequency Counting (Baseline)
    // ===========================================================
    /**
     * Uses HashMap to count frequencies.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int majorityElement_hashMap(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > n / 2) {
                return num;
            }
        }
        return -1; // unreachable as per problem constraints
    }

    // ===========================================================
    // Recommended Default (Interview Choice)
    // ===========================================================
    public int solution(int[] nums) {
        return majorityElement_boyerMoore(nums);
    }

    // ===========================================================
    public static void main(String[] args) {
        _012majorityElement solver =
                new _012majorityElement();

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Array           : " + Arrays.toString(nums));
        System.out.println("Majority Element: " + solver.solution(nums));
    }
}


