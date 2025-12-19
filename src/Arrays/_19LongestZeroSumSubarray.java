package Arrays;
/*
Problem: Length of the Longest Subarray with Sum 0

Given an integer array arr[] of size N, find the length of the longest
contiguous subarray whose elements sum to 0.

A subarray is a contiguous part of the array.

Input:
- An integer array arr[] containing both positive and negative numbers.

Output:
- Return an integer representing the length of the longest subarray
  with sum equal to 0.

Example 1:
Input:
arr = [1, -1, 3, -3, 4, -4]
Output:
6
Explanation:
The entire array sums to 0, so the length of the longest subarray is 6.

Example 2:
Input:
arr = [4, -2, -2, 2, 2, -4, 2]
Output:
6
Explanation:
The subarray [4, -2, -2, 2, 2, -4] has sum 0 and length 6.

Constraints:
- 1 ≤ N ≤ 10^5
- -10^5 ≤ arr[i] ≤ 10^5

Expected Time Complexity:
- O(N)

Expected Space Complexity:
- O(N)
*/

import java.util.HashMap;

public class _19LongestZeroSumSubarray {
    public static int maxSubarraysumZero(int nums[]){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        int maxLen = 0;

        for(int i=0;i<n;i++){
            preSum+=nums[i];

            if(preSum==0){
                maxLen=i+1;
            }
            if (map.containsKey(preSum)){
                maxLen=Math.max(maxLen,i-map.get(preSum));
            }else{
                map.put(preSum,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};

        int result = maxSubarraysumZero(nums);
        System.out.println("Length of longest zero-sum subarray: " + result);
    }
}
/*
 INTERVIEW EXPLANATION – LARGEST SUBARRAY WITH ZERO SUM

 Problem:
 Given an array, find the length of the longest contiguous subarray
 whose sum is equal to 0.

 Key Idea:
 Use Prefix Sum + HashMap.

 Observation:
 - If prefixSum becomes 0 at index i, then subarray [0..i] has sum 0.
 - If the same prefixSum occurs again at index j,
   then the subarray between those two indices has sum 0.

   Because:
   prefixSum[j] - prefixSum[i] = 0  → sum(i+1 to j) = 0

 Approach:
 - Traverse the array while maintaining a running prefixSum.
 - Store the FIRST occurrence of each prefixSum in a HashMap.
 - If prefixSum == 0, update max length as i + 1.
 - If prefixSum is already in the map,
   calculate length = currentIndex - firstIndexStored.
 - Always keep the maximum length found.

 Important Note:
 - Store only the first occurrence of each prefixSum
   to maximize the subarray length.

 Time Complexity: O(n)
 Space Complexity: O(n)
*/
