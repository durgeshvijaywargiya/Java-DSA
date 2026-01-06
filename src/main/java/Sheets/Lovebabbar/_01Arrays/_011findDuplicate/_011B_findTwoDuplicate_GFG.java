package Sheets.Lovebabbar._01Arrays._011findDuplicate;
import java.util.Arrays;
public class _011B_findTwoDuplicate_GFG {

    // ===========================================================
    // METHOD 1: Counting Array (YOUR SOLUTION)
    // ===========================================================
    /**
     * Uses frequency array to detect repeated elements.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Preserves the order of second appearance.
     */
    public int[] twoRepeated_counting(int[] arr) {
        int len = arr.length;
        int[] ans = new int[2];
        int pos = 0;

        int[] cnt = new int[len + 1];

        for (int i = 0; i < len; i++) {
            cnt[arr[i]]++;
            if (cnt[arr[i]] > 1) {
                ans[pos++] = arr[i];
            }
        }
        return ans;
    }

    // ===========================================================
    // METHOD 2: In-Place Sign Marking (FAANG PREFERRED)
    // ===========================================================
    /**
     * Uses array index marking (negation trick).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Modifies the input array.
     */
    public int[] twoRepeated_inPlace(int[] arr) {
        int[] ans = new int[2];
        int pos = 0;

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);

            if (arr[index] < 0) {
                ans[pos++] = index;
            } else {
                arr[index] = -arr[index];
            }
        }
        return ans;
    }

    // ===========================================================
    // Recommended Default
    // ===========================================================
    public int[] solution(int[] arr) {
        return twoRepeated_inPlace(arr);
    }

    // ===========================================================
    public static void main(String[] args) {
        _011B_findTwoDuplicate_GFG solver =
                new _011B_findTwoDuplicate_GFG();

        int[] arr = {1, 2, 1, 3, 4, 3};

        System.out.println("Repeated elements: " +
                Arrays.toString(solver.solution(arr)));
    }
}
