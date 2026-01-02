package SlidingWindow.Type1;

/*
Problem Statement:
Given an array of integers arr, an integer k, and an integer threshold,
return the number of subarrays of size k whose average is greater than
or equal to threshold.

Example:
Input: arr = [2, 2, 2, 2, 5, 5, 5, 8], k = 3, threshold = 4
Output: 3

Explanation:
Subarrays with average >= 4 are:
[2,5,5], [5,5,5], [5,5,8]

Constraints:
- 1 <= arr.length <= 10^5
- 1 <= k <= arr.length
*/

public class _3NumOfSubarraysAvgThreshold {

    // Fixed Size Sliding Window
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int sum = 0;
        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= k * threshold) count++;

        // Slide the window
        for (int i = k; i < n; i++) {
            sum -= arr[i - k];
            sum += arr[i];

            if (sum >= k * threshold) count++;
        }

        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        int result = numOfSubarrays(arr, k, threshold);
        System.out.println("Number of subarrays: " + result);
    }
}

