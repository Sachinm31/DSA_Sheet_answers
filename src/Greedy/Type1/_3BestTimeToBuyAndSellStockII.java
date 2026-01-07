package Greedy.Type1;

public class _3BestTimeToBuyAndSellStockII {

    /*
     * ============================================================
     * LeetCode 122: Best Time to Buy and Sell Stock II
     * ============================================================
     *
     * Problem Statement:
     * You are given an integer array prices[] where prices[i]
     * represents the price of a given stock on the i-th day.
     *
     * You can complete as many transactions as you like
     * (i.e., buy one and sell one share of the stock multiple times).
     *
     * Important Rules:
     * - You cannot hold more than one stock at a time.
     * - You must sell before you buy again.
     *
     * Goal:
     * Maximize total profit.
     *
     * Example:
     * prices = [7,1,5,3,6,4]
     * Output = 7
     *
     * Explanation:
     * Buy at 1, sell at 5 → profit = 4
     * Buy at 3, sell at 6 → profit = 3
     * Total = 7
     *
     * Constraints:
     * 1 <= prices.length <= 3 * 10^4
     * 0 <= prices[i] <= 10^4
     */

    /*
     * ============================================================
     * Greedy Thinking:
     * ============================================================
     *
     * Key Insight:
     * - Every increasing sequence can be split into multiple
     *   profitable transactions.
     *
     * Example:
     * prices = [1, 2, 3, 4]
     *
     * Instead of:
     * Buy at 1, Sell at 4 → profit = 3
     *
     * We can do:
     * (2 - 1) + (3 - 2) + (4 - 3) = 3
     *
     * Same profit, but easier to compute greedily.
     *
     * Greedy Rule:
     * - If today's price > yesterday's price,
     *   take the profit.
     */

    // Static method as requested
    public static int maxProfit(int[] prices) {

        int profit = 0;

        // Traverse from day 1 to last day
        for (int i = 1; i < prices.length; i++) {

            // If price increases, take the profit
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    /*
     * ============================================================
     * Time & Space Complexity:
     * ============================================================
     *
     * Time Complexity:
     * - O(n) → single pass
     *
     * Space Complexity:
     * - O(1) → constant extra space
     */

    // Main method for local testing
    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices1)); // Expected: 7
        System.out.println(maxProfit(prices2)); // Expected: 4
        System.out.println(maxProfit(prices3)); // Expected: 0
    }
}
