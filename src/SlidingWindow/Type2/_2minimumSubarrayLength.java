package SlidingWindow.Type2;

/*
 PROBLEM STATEMENT:
 ------------------
 Given an array of positive integers nums and a positive integer target,
 return the minimal length of a contiguous subarray of which the sum
 is greater than or equal to target.
 If there is no such subarray, return 0.

 Example:
 Input:  target = 7, nums = [2,3,1,2,4,3]
 Output: 2
 Explanation: The subarray [4,3] has the minimal length.

 TECHNIQUE USED:
 ----------------
 Sliding Window (Variable Size)

 KEY OBSERVATION:
 ----------------
 - All numbers are POSITIVE
 - Expanding the window increases sum
 - Shrinking the window decreases sum

 TIME COMPLEXITY:
 ----------------
 O(n) — each element is visited at most twice

 SPACE COMPLEXITY:
 -----------------
 O(1)
*/

public class _2minimumSubarrayLength {

    // -------- STATIC METHOD --------
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for (int end = 0; end < n; end++) {
            sum += nums[end];

            // shrink window while condition satisfied
            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;

        int[] nums2 = {1, 1, 1, 1};
        int target2 = 11;

        System.out.println(minSubArrayLen(target1, nums1)); // 2
        System.out.println(minSubArrayLen(target2, nums2)); // 0
    }
}
