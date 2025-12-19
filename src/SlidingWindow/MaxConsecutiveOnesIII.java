package SlidingWindow;
/**
 * Problem: Max Consecutive Ones III (LeetCode 1004)
 *
 * Given a binary array nums and an integer k,
 * you are allowed to flip at most k zeros to ones.
 *
 * Return the maximum number of consecutive 1s you can get in the array.
 *
 * Example:
 * nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Answer = 6
 *
 * Explanation:
 * - We can flip two zeros in the best window to get the maximum stretch of 1s.
 *
 * Approach: Sliding Window (Variable Size, "At Most K Zeros")
 * -----------------------------------------------------------
 * 1️⃣ Use two pointers: start (left) and end (right) to represent a window.
 * 2️⃣ Expand the window by moving 'end' and include nums[end].
 *     - If nums[end] == 0, increase count of zeros.
 * 3️⃣ While zeros in current window > k:
 *     - Shrink the window from the left (move 'start' forward),
 *     - If nums[start] was 0, decrement zeros count.
 * 4️⃣ At each step, when zeros <= k, the window [start..end] is valid:
 *     - Update maxLen = max(maxLen, end - start + 1)
 *
 * This gives the longest subarray where we can make all elements 1
 * by flipping at most k zeros.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class MaxConsecutiveOnesIII {

    public static int maxOnes(int nums[],int k){
        int start = 0;
        int n = nums.length;
        int maxLen = 0;
        int zeros = 0;

        for(int end=0;end<n;end++){
            if(nums[end]==0){
                zeros++;
            }
            while(zeros>k){
                if(nums[start]==0){
                    zeros--;
                }
                start++;
            }
            maxLen = Math.max(maxLen,(end-start)+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int nums[] ={1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int ans = maxOnes(nums,k);
        System.out.println(ans);
    }
}
