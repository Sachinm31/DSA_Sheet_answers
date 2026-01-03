package SlidingWindow.Type2;

import java.util.HashMap;

/*
 PROBLEM STATEMENT (LeetCode 904):
 --------------------------------
 You are given an integer array fruits where fruits[i] is the type of fruit
 produced by the ith tree.

 You have two baskets, and each basket can hold only one type of fruit.
 You can pick exactly one fruit from each tree while moving from left to right.
 Once you start picking, you must stop when you can no longer pick fruits.

 Return the maximum number of fruits you can pick.

 In other words, find the length of the longest contiguous subarray
 containing at most two distinct integers.

 Example:
 Input:  fruits = [1,2,1]
 Output: 3

 TECHNIQUE USED:
 ----------------
 Sliding Window (At most K distinct elements, K = 2)

 KEY LOGIC:
 ----------
 - Use a HashMap to count fruit types in the window
 - Window is valid if map.size() <= 2
 - If map.size() > 2, shrink window from left

 TIME COMPLEXITY:
 ----------------
 O(n)

 SPACE COMPLEXITY:
 -----------------
 O(2) ≈ O(1)
*/

public class _5FruitIntoBaskets {

    // -------- STATIC METHOD --------
    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            // add current fruit
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // shrink window if more than 2 types
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        int[] fruits1 = {1, 2, 1};
        int[] fruits2 = {0, 1, 2, 2};
        int[] fruits3 = {1, 2, 3, 2, 2};

        System.out.println(totalFruit(fruits1)); // 3
        System.out.println(totalFruit(fruits2)); // 3
        System.out.println(totalFruit(fruits3)); // 4
    }
}
