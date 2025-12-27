package Sheets.Lovebabbar._01Arrays._07rotateArray;
import java.util.Arrays;
public class _007A_cyclicallyRotateArrayByOne_GFG {

    // -----------------------------------------------------------
    // method1_extraArray (YOUR ORIGINAL APPROACH)
    // -----------------------------------------------------------
    /**
     * Rotates array clockwise by one using extra array.

     * Time: O(n)
     * Space: O(n)
     */
    public void method1_extraArray(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + 1) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // -----------------------------------------------------------
    // method2_extraArrayOptimised
    // -----------------------------------------------------------
    /**
     * Same logic as method1, but cleaner and faster copy.

     * Time: O(n)
     * Space: O(n)
     */
    public void method2_extraArrayOptimised(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + 1) % n] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }

    // -----------------------------------------------------------
    // method3_inPlace (FAANG PREFERRED)
    // -----------------------------------------------------------
    /**
     * In-place rotation by one.

     * Steps:
     * 1. Save last element
     * 2. Shift elements right
     * 3. Place last at index 0

     * Time: O(n)
     * Space: O(1)
     */
    public void method3_inPlace(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        int last = nums[n - 1];

        for (int i = n - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }

        nums[0] = last;
    }

    // -----------------------------------------------------------
    // Recommended Default
    // -----------------------------------------------------------
    public void solution(int[] nums) {
        method3_inPlace(nums);
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        _007A_cyclicallyRotateArrayByOne_GFG solver =
                new _007A_cyclicallyRotateArrayByOne_GFG();

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(nums));

        solver.solution(nums);

        System.out.println("After : " + Arrays.toString(nums));
    }
}

