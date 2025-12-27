package Other.Leetcode;
import java.util.HashSet;
import java.util.Set;
public class _012findDuplicates {

    // ===========================================================
    // METHOD 1: Negative Marking (Your First Solution)
    // ===========================================================
    /**
     * Uses array index marking by negating values.

     * Time Complexity: O(n)
     * Space Complexity: O(1)

     * ⚠️ Modifies the input array (NOT allowed by problem constraints)
     */
    public int findDuplicate_negativeMarking(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] = -nums[index];
        }
        return -1; // unreachable for valid input
    }

    // ===========================================================
    // METHOD 2: HashSet (Your Second Solution)
    // ===========================================================
    /**
     * Uses HashSet to track seen numbers.

     * Time Complexity: O(n)
     * Space Complexity: O(n)

     * ❌ Violates constant space constraint
     */
    public int findDuplicate_hashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // ===========================================================
    // METHOD 3: Frequency Array (Your Third Solution)
    // ===========================================================
    /**
     * Uses counting array to track occurrences.

     * Time Complexity: O(n)
     * Space Complexity: O(n)

     * ❌ Extra space not allowed by problem
     */
    public int findDuplicate_counting(int[] nums) {
        int[] cnt = new int[nums.length + 1];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > 1) {
                return num;
            }
        }
        return -1;
    }

    // ===========================================================
    // METHOD 4: Floyd’s Tortoise and Hare (FAANG PREFERRED)
    // ===========================================================
    /**
     * Uses cycle detection without modifying array and constant space.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findDuplicate_floyd(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entry point of cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // ===========================================================
    // Recommended Default (FAANG Interview Choice)
    // ===========================================================
    public int solution(int[] nums) {
        return findDuplicate_floyd(nums);
    }

    // ===========================================================
    public static void main(String[] args) {
        _012findDuplicates solver =
                new _012findDuplicates();

        int[] nums = {1, 3, 4, 2, 2};

        System.out.println("Duplicate Number = " + solver.solution(nums));
    }
}


