package SlidingWindow.Type1;
/**
 * Problem: Fruit Into Baskets (LeetCode 904)
 *
 * You have two baskets, each basket can only store one type of fruit.
 * You must take fruits from trees in a continuous line.
 *
 * Return: Maximum number of fruits you can collect
 * with at most TWO distinct fruit types in the subarray.
 *
 * Approach: Sliding Window + HashMap (At Most 2 Distinct)
 *
 * Time: O(n) — end and start move once
 * Space: O(1) — at most 2 types stored in map
 */

import java.util.*;
public class fruitBasket {

    public static int maxTree(int nums[]){
        HashMap<Integer,Integer>map = new HashMap<>();
        int  start = 0;
        int n = nums.length;
        int max = 0;

        for(int end=0;end<n;end++){
            int fruit = nums[end];
            map.put(fruit,map.getOrDefault(fruit,0)+1);

            while(map.size()>2){
                int left = nums[start];
                map.put(left,map.get(left)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                start++;
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println("Max fruits: " + maxTree(fruits));
        // Output: 4  (subarray: [3,2,2,?] or [2,3,2,2])
    }
}