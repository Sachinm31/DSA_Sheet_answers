package SlidingWindow.Type3;
import java.util.*;
/*
 Problem Statement:
 ------------------
 You are given a sorted array of integers nums and an integer target.

 Find two numbers in the array such that they add up to the given target
 and return their indices.

 Conditions:
 - The input array is sorted in non-decreasing order
 - Return 1-based indices of the two numbers
 - You cannot use the same element twice
 - If no such pair exists, return {-1, -1}

 Example:
 Input: nums = [2, 7, 11, 15], target = 9
 Output: [1, 2]
 Explanation: nums[1] + nums[2] = 2 + 7 = 9

 Approach:
 ---------
 Use the Two Pointer technique.
 - Initialize left pointer at start, right pointer at end
 - If sum == target → return indices
 - If sum < target → move left pointer forward
 - If sum > target → move right pointer backward

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class _2TwoSum2 {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                // 1-based index (like LeetCode 167)
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    // ✅ main method
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15}; // MUST be sorted
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
