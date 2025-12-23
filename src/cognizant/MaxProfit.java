    package cognizant;
    import java.util.*;
    //1. Maximum Profit
    //        Problem Statement: You own a store and want to maximize profit by buying and selling items. You are given N items with specific buying prices and selling prices. You can select at most M items to buy and sell. Your goal is to calculate the maximum total profit possible.
    //
    //        Profit per item = Selling Price - Buying Price.
    //
    //        You should only select items that result in a profit (profit > 0).
    //
    //        You cannot exceed the limit of M items.
    //
    //        Input Format:
    //
    //        input1: Integer N (Total number of items).
    //
    //        input2: Integer Array B (Buying prices).
    //
    //        input3: Integer Array S (Selling prices).
    //
    //        input4: Integer M (Maximum items you can trade).
    //
    //        Output Format:
    //
    //        Return an integer representing the maximum profit.
    public class MaxProfit {
        public static int maxProfit(int input1, int[] input2, int[] input3, int input4) {
            // input1: N (Number of items)
            // input2: B (Buying prices array)
            // input3: S (Selling prices array)
            // input4: M (Max items to sell)

            int profit[] = new int[input1];
            int maxProfit = 0;

            for(int i=0;i<input1;i++){
                profit[i]=input3[i]-input2[i];
            }

            Arrays.sort(profit);
            int moves = 0;
            int m = input4;

//            Example of why it fails:
//
//            Imagine you have 3 items.
//
//                    Profits: [100, -10, -20] (One good item, two bad items).
//
//            M = 3 (You are allowed to buy up to 3 items).
//
//            Your Code: Will add 100 + (-10) + (-20) = 70.
//
//            Correct Answer: Should only pick 100 and stop. Result = 100.

            for(int i=input1-1;i>=0;i--){
                if(moves>=m){
                    break;
                }
                if(profit[i]<=0){
                    break;
                }
                maxProfit+=profit[i];
                moves++;
            }
            return maxProfit;
        }

        public static void main(String[] args) {
            // Test logic
            int n = 3;
            int[] b = {10, 20, 30};
            int[] s = {110, 10, 10}; // Profits: 100, -10, -20
            int m = 3;

            System.out.println(maxProfit(n, b, s, m)); // Should print 100
        }
    }
