package Other.Leetcode;

public class _009minDeletionCostToMakeAllCharacterEqual {

    // ===========================================================
    // APPROACH: Total Cost - Max Cost of One Character
    // ===========================================================
    /**
     * Returns the minimum deletion cost such that the remaining string
     * is non-empty and contains only one unique character.

     * Time Complexity: O(n + 26) ≈ O(n)
     * Space Complexity: O(26) ≈ O(1)
     */
    public long minCost(String s, int[] cost) {
        long totalCost = 0;
        long[] charCostSum = new long[26];

        // Accumulate total cost and per-character cost
        for (int i = 0; i < s.length(); i++) {
            totalCost += cost[i];
            int idx = s.charAt(i) - 'a';
            charCostSum[idx] += cost[i];
        }

        long answer = totalCost;

        // Try keeping only one character type
        for (int i = 0; i < 26; i++) {
            if (charCostSum[i] > 0) {
                answer = Math.min(answer, totalCost - charCostSum[i]);
            }
        }

        return answer;
    }



    // ===========================================================
    // Recommended Default
    // ===========================================================
    public long solution(String s, int[] cost) {
        return minCost(s, cost);
    }

    // ===========================================================
    public static void main(String[] args) {
        _009minDeletionCostToMakeAllCharacterEqual solver =
                new _009minDeletionCostToMakeAllCharacterEqual();

        String s = "aabaac";
        int[] cost = {1,2,3,4,1,10};

        System.out.println("Minimum Deletion Cost = " +
                solver.solution(s, cost));
    }
}


