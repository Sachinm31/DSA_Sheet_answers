package SlidingWindow.Type4;

/*
 Problem Statement (LeetCode 80: Remove Duplicates from Sorted Array II)
 ---------------------------------------------------------------------
 You are given a sorted integer array nums.

 Remove duplicates in-place such that each element appears
 at most twice and return the new length.

 Conditions:
 - The array is sorted
 - Do not use extra space
 - Modify the array in-place
 - Order must be preserved

 Example:
 Input:  nums = [0,0,1,1,1,1,2,3,3]
 Output: 7
 Modified nums = [0,0,1,1,2,3,3,_,_]

 Approach:
 ---------
 Two Pointer Technique (Overwrite Method)

 Key Idea:
 - Allow at most two occurrences of each number
 - Compare current element with nums[i - 2]

 Logic:
 - Start placing elements from index 2
 - If nums[j] != nums[i - 2], it is safe to keep

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class _3RemoveDuplicatesII {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int i = 2;

        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // ✅ static main method
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};

        int k = removeDuplicates(nums);

        System.out.println("Valid length: " + k);
        System.out.print("Array after removal: ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        // Expected Output:
        // Valid length: 7
        // Array after removal: 0 0 1 1 2 3 3
    }
}
