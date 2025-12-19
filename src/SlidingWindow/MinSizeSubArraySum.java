package SlidingWindow;
/**
 * Problem: Minimum Size Subarray Sum (LeetCode 209)
 *
 * Given an array of positive integers nums and a positive integer target,
 * find the minimal length of a contiguous subarray of which the sum
 * is greater than or equal to target. If there is no such subarray, return 0.
 *
 * Example:
 * target = 7
 * nums = [2,3,1,2,4,3]
 *
 * Possible valid subarrays (sum >= 7):
 * [2,3,1,2]  -> sum = 8   -> length = 4
 * [3,1,2,4]  -> sum = 10  -> length = 4
 * [4,3]      -> sum = 7   -> length = 2 <- minimum
 *
 * Answer = 2
 *
 * Approach: Sliding Window (Variable Size)
 * ----------------------------------------
 * 1️⃣ Expand the window by moving end pointer and adding elements to sum
 * 2️⃣ Once sum >= target, try shrinking the window from the left (start pointer)
 *     → update minimum length
 *     → subtract left element from sum
 *     → move start forward
 * 3️⃣ Continue until end reaches end of array
 *
 * Why works in O(n)?
 *  - Each element is added once and removed once → linear time
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinSizeSubArraySum {
    public static int minsize(int nums[],int target){
        int start = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        for(int end = 0;end<n;end++){
            sum+=nums[end];

            while(sum>=target){
                min=Math.min(min,(end-start)+1);
                sum-=nums[start];
                start++;
            }
        }
        return (min==Integer.MAX_VALUE)?0 : min;

    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        int res = minsize(nums,target);
        System.out.println(res);
    }
}


















