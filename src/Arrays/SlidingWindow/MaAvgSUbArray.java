package Arrays.SlidingWindow;

/**
 * Problem: Maximum Average Subarray of Size K (LeetCode 643 style)
 *
 * Given an integer array nums and an integer k,
 * find the contiguous subarray of length k that has the maximum average value,
 * and return this maximum average.
 *
 * Example:
 * nums = [1, 12, -5, -6, 50, 3], k = 4
 *
 * Suba rrays of size 4:
 * [1, 12, -5, -6]  -> sum = 2   -> avg = 0.5
 * [12, -5, -6, 50] -> sum = 51  -> avg = 12.75  (max)
 * [-5, -6, 50, 3]  -> sum = 42  -> avg = 10.5
 *
 * Answer = 12.75
 *
 * Approach (Sliding Window - Fixed Size):
 * --------------------------------------
 * 1. First, compute the sum of the first window of size k: nums[0..k-1]
 * 2. This is our initial windowSum and maxSum.
 * 3. Now slide the window one step at a time towards the right:
 *      - When window moves from (i-k+1 .. i) to (i-k+2 .. i+1):
 *        we remove nums[i-k+1-1] = nums[i-k] from sum
 *        and add nums[i+1]
 *
 *    In terms of index `i` in loop starting from k:
 *      newSum = oldSum - nums[i - k] + nums[i]
 *
 * 4. At each slide, update maxSum if current window sum is greater.
 * 5. At the end, maximum average = maxSum / k.
 *
 * Time Complexity:  O(n)  (each element added and removed at most once)
 * Space Complexity: O(1)
 */
public class MaAvgSUbArray {

    /**
     * Function to find maximum average of any subarray of size k.
     *
     * @param nums input array
     * @param k size of the subarray
     * @return maximum average value among all subarrays of size k
     */
    public static double maxAvg(int nums[], int k) {
        int n = nums.length;

        // Step 1: Compute sum of the first window of size k: nums[0..k-1]
        long sum = 0; // use long to avoid overflow when numbers are large
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // This is the sum of the first window and initial maxSum
        long maxSum = sum;

        // Step 2: Slide the window from index k to n-1
        // Window at step i represents subarray nums[i-k+1 .. i]
        for (int i = k; i < n; i++) {
            // Remove the element going out of window: nums[i - k]
            // Add the new element coming into window: nums[i]
            sum = sum - nums[i - k] + nums[i];

            // Update maxSum if current window sum is greater
            maxSum = Math.max(maxSum, sum);
        }

        // Step 3: Convert max sum to max average
        // Cast to double to ensure floating point division
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int nums[] = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double ans = maxAvg(nums, k);
        System.out.println("Maximum average of subarray of size " + k + " = " + ans);
        // Expected output: 12.75
    }
}
