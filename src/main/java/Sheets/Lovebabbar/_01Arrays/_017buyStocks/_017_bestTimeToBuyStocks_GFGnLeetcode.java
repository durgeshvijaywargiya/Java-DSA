package Sheets.Lovebabbar._01Arrays._017buyStocks;
import java.util.Arrays;

public class _017_bestTimeToBuyStocks_GFGnLeetcode {

    // ===========================================================
    // APPROACH 1: Min Price Tracking (Most Common & Intuitive)
    // ===========================================================
    /**
     * Tracks the minimum price so far and computes max profit.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxProfit_minPrice(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    // ===========================================================
    // APPROACH 2: Kadane’s Algorithm Variant (Your First Solution)
    // ===========================================================
    /**
     * Converts problem into maximum subarray on daily price differences.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxProfit_kadane(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int maxCurrent = 0;
        int maxSoFar = 0;

        for (int i = 1; i < prices.length; i++) {
            maxCurrent = Math.max(0, maxCurrent + prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxSoFar, maxCurrent);
        }
        return maxSoFar;
    }

    // ===========================================================
    // Recommended Default (Interview-Friendly)
    // ===========================================================
    public int solution(int[] prices) {
        return maxProfit_minPrice(prices);
    }

    // ===========================================================
    public static void main(String[] args) {
        _017_bestTimeToBuyStocks_GFGnLeetcode solver =
                new _017_bestTimeToBuyStocks_GFGnLeetcode();

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Prices     : " + Arrays.toString(prices));
        System.out.println("Max Profit : " + solver.solution(prices));
    }
}
