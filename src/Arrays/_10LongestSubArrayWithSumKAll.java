package Arrays;
/*
Problem: Longest Subarray with Given Sum K (Positive + Negative)

Given an array containing positive, negative, and zero values
and an integer k, find the length of the longest subarray
whose sum is equal to k.

If no such subarray exists, return 0.
*/

import java.util.HashMap;

public class _10LongestSubArrayWithSumKAll {
    public static int longestSubarrayAll(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == k) {
                maxLen = i + 1;
            }

            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }

            // store first occurrence only
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {

        int[] arr2 = {10, 5, 2, 7, 1, -10};
        System.out.println("Pos + Neg: " + longestSubarrayAll(arr2, 15));
    }
}
