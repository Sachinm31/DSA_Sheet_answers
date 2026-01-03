package SlidingWindow.Type2;

/*
 PROBLEM STATEMENT (LeetCode 1004):
 ---------------------------------
 Given a binary array nums and an integer k, return the maximum number
 of consecutive 1s in the array if you can flip at most k 0s.

 Example:
 Input:  nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 Output: 6
 Explanation:
 Flip two 0s to get the longest subarray of consecutive 1s of length 6.

 TECHNIQUE USED:
 ----------------
 Sliding Window (Variable Size)

 KEY LOGIC:
 ----------
 - Count number of zeros in the window
 - Window is valid if zeroCount <= k
 - If zeroCount > k, shrink window from left

 TIME COMPLEXITY:
 ----------------
 O(n)

 SPACE COMPLEXITY:
 -----------------
 O(1)
*/

public class _4MaxConsecutiveOnesIII {

    // -------- STATIC METHOD --------
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            // shrink window if zeros exceed k
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;

        int[] nums2 = {0,0,1,1,0,1,1,1,0};
        int k2 = 1;

        System.out.println(longestOnes(nums1, k1)); // 6
        System.out.println(longestOnes(nums2, k2)); // 4
    }
}
