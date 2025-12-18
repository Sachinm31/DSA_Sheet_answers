package Arrays;

public class _16BestTimeToBuyStock {
    /*
Problem: Best Time to Buy and Sell Stock (LeetCode 121)

You are given an integer array prices where prices[i] represents the price
of a stock on the i-th day.

You want to maximize your profit by choosing exactly one day to buy one stock
and choosing a different day in the future to sell that stock.

Rules:
1. You can complete only one transaction (buy once and sell once).
2. You must buy before you sell.
3. If no profit is possible, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation:
Buy on day 2 at price 1 and sell on day 5 at price 6.
Profit = 6 - 1 = 5.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation:
Prices are decreasing, so no profit is possible.

Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
*/
    public static int maxProfit(int nums[]){
        int maxPro = 0;
        int minVal = Integer.MAX_VALUE;

        for(int num : nums){
            if(num<minVal){
                minVal = num;
            } maxPro=Math.max(maxPro,num-minVal);
        }
        return maxPro;
    }
    public static void main(String[] args) {


        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices1));
        // Expected Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + maxProfit(prices2));
        // Expected Output: 0
    }
}
