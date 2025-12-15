package Arrays;
/*
Problem: Longest Subarray with Given Sum K (Positive Numbers)

Given an array of positive integers arr[] and an integer k,
find the length of the longest subarray whose sum is exactly k.

If no such subarray exists, return 0.

Example:
Input: arr = [1, 2, 3, 1, 1, 1, 1], k = 3
Output: 3
Explanation: Subarray [1,1,1] has sum = 3 and maximum length.
*/

public class _9LongestSubArrayWithSumK_PositiveOnly {
    public static int longestSubarray(int[] arr, int k) {
        int start = 0, sum = 0, maxLen = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > k) {
                sum -= arr[start];
                start++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {



        int[] arr2 = {10, 5, 2, 7, 1, -10};
        System.out.println("Pos + Neg: " + longestSubarray(arr2, 15));
    }
}
