package SlidingWindow.Type1;

/*
Problem Statement:
Given an array of integers and a number k, find the maximum sum of any
contiguous subarray of size k.

Example:
Input: arr = [2, 1, 5, 1, 3, 2], k = 3
Output: 9
Explanation: Subarray [5, 1, 3] has the maximum sum = 9.

Constraints:
- 1 ≤ k ≤ arr.length
- Array contains integers
*/

public class _1maxSubarraySum {

    // Fixed Size Sliding Window
    public static int maxSubarraySum(int[] arr, int k) {
        // Edge case: if window size is greater than array length
        if (k > arr.length) return -1;

        int sum = 0;

        // Step 1: Calculate sum of first window of size k
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        // Step 2: Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            sum -= arr[i - k]; // remove element leaving the window
            sum += arr[i];     // add element entering the window
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maxSubarraySum(arr, k);
        System.out.println("Maximum subarray sum of size " + k + " is: " + result);
    }
}
