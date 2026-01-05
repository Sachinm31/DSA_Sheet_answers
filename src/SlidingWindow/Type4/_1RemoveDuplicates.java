package SlidingWindow.Type4;

/*
 Problem Statement (LeetCode 26: Remove Duplicates from Sorted Array)
 -------------------------------------------------------------------
 You are given a sorted integer array nums.

 Your task is to remove the duplicates in-place such that each unique
 element appears only once and return the number of unique elements.

 Important:
 - The relative order of elements must be preserved
 - Do not use extra space
 - Modify the input array in-place

 Example:
 Input:  nums = [1,1,2,2,3]
 Output: 3
 Modified nums = [1,2,3,_,_]

 Approach:
 ---------
 Two Pointer Technique (Slow & Fast Pointer)

 Pointers:
 - i → slow pointer (tracks last unique element index)
 - j → fast pointer (scans the array)

 Logic:
 - Start i at index 0
 - Traverse array with j from index 1
 - If nums[i] != nums[j]:
     - Increment i
     - Copy nums[j] to nums[i]

 At the end:
 - Unique elements count = i + 1

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class _1RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // ✅ static main method
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};

        int k = removeDuplicates(nums);

        System.out.println("Unique count: " + k);
        System.out.print("Array after removal: ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        // Expected Output:
        // Unique count: 3
        // Array after removal: 1 2 3
    }
}
