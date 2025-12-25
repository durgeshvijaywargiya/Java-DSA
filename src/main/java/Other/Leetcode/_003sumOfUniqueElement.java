package Other.Leetcode;
import java.util.HashMap;
import java.util.HashSet;

public class _003sumOfUniqueElement {

    // -----------------------------------------------------------
    // method1_frequencyArray (YOUR ORIGINAL - BEST)
    // -----------------------------------------------------------
    /**
     * Uses frequency array based on constraints:
     * 1 <= nums[i] <= 100
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int method1_frequencyArray(int[] nums) {
        int[] freq = new int[100];
        int sum = 0;

        for (int x : nums) {
            freq[x - 1]++;
        }

        for (int i = 0; i < 100; i++) {
            if (freq[i] == 1) {
                sum += (i + 1);
            }
        }
        return sum;
    }

    // -----------------------------------------------------------
    // method2_hashMap (General solution)
    // -----------------------------------------------------------
    /**
     * Uses HashMap to count frequencies.
     * Works for any value range.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public int method2_hashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                sum += key;
            }
        }
        return sum;
    }

    // -----------------------------------------------------------
    // method3_twoHashSet (Elegant alternative)
    // -----------------------------------------------------------
    /**
     * Uses two sets:
     * - seen: first-time elements
     * - duplicate: repeated elements
     *
     * Time: O(n)
     * Space: O(n)
     */
    public int method3_twoHashSet(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicate = new HashSet<>();

        for (int x : nums) {
            if (!seen.add(x)) {
                duplicate.add(x);
            }
        }

        int sum = 0;
        for (int x : seen) {
            if (!duplicate.contains(x)) {
                sum += x;
            }
        }
        return sum;
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    public int solution(int[] nums) {
        return method1_frequencyArray(nums);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        _003sumOfUniqueElement solver =
                new _003sumOfUniqueElement();

        int[] nums = {1, 2, 3, 2};
        System.out.println("Sum of unique elements: " +
                solver.solution(nums));
    }
}
