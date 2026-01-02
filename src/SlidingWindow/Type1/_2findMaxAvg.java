package SlidingWindow.Type1;

/*
Problem Statement:
Given an integer array nums and an integer k, find the maximum average value
of any contiguous subarray of length k.

Return the maximum average.

Example:
Input: nums = [1, 12, -5, -6, 50, 3], k = 4
Output: 12.75
Explanation: Subarray [12, -5, -6, 50] has the maximum average.

Constraints:
- 1 <= k <= nums.length
- nums[i] can be negative or positive
*/

public class _2findMaxAvg {

    // Fixed Size Sliding Window method
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return -1;

        double sum = 0;

        // Step 1: Calculate sum of first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = sum / k;

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            sum -= nums[i - k]; // remove element leaving window
            sum += nums[i];     // add element entering window
            maxAvg = Math.max(maxAvg, sum / k);
        }

        return maxAvg;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double result = findMaxAverage(nums, k);
        System.out.println("Maximum average subarray of size " + k + " is: " + result);
    }
}
