package SlidingWindow.Type4;
/*
 PROBLEM STATEMENT (PS):

 Given an integer array nums containing n + 1 integers
 where each integer is in the range [1, n] inclusive.

 There is only ONE repeated number in nums.
 Return this repeated number.

 Constraints:
 - You must NOT modify the array
 - Use only constant extra space O(1)
 - Time complexity should be less than O(n^2)

 Example:
 Input : nums = [1,3,4,2,2]
 Output: 2
*/

public class _4FindDuplicateNumber {

    /*
     APPROACH:
     ----------
     Floyd's Cycle Detection (Tortoise & Hare)

     Treat the array as a linked list:
     index -> nums[index]

     Because one number is duplicated,
     a cycle MUST exist.

     The duplicate number is the ENTRY POINT of the cycle.
    */

    public static int findDuplicate(int[] nums) {

        // Step 1: Initialize slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];

        /*
         PHASE 1: Detect cycle
         slow moves 1 step
         fast moves 2 steps
         They will meet inside the cycle
        */
        do {
            slow = nums[slow];          // move by 1
            fast = nums[nums[fast]];   // move by 2
        } while (slow != fast);

        /*
         PHASE 2: Find cycle entry
         Reset slow to start
         Move both pointers one step at a time
         They meet at the duplicate number
        */
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // slow (or fast) now points to the duplicate number
        return slow;
    }

    // Main method for testing
    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};

        int result = findDuplicate(nums);

        System.out.println("Duplicate number is: " + result);
    }
}
