package SlidingWindow.Type3;

/*
 Problem Statement (LeetCode 75: Sort Colors)
 -------------------------------------------
 You are given an array nums containing only 0s, 1s, and 2s.

 Each number represents a color:
 0 -> Red
 1 -> White
 2 -> Blue

 Your task is to sort the array in-place so that all 0s come first,
 followed by all 1s, and then all 2s.

 Constraints:
 - Do not use the built-in sort function
 - Must be done in one pass
 - Use constant extra space (O(1))

 Example:
 Input:  nums = [2, 0, 2, 1, 1, 0]
 Output: [0, 0, 1, 1, 2, 2]

 Approach:
 ---------
 Use the Dutch National Flag algorithm (Three Pointer Technique).

 Pointers:
 - low  : boundary for 0s
 - mid  : current element
 - high : boundary for 2s

 Logic:
 - If nums[mid] == 0 → swap with low, low++, mid++
 - If nums[mid] == 1 → mid++
 - If nums[mid] == 2 → swap with high, high--

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class _4SortColors {

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        // Print sorted array
        for (int n : nums) {
            System.out.print(n + " ");
        }
        // Output: 0 0 1 1 2 2
    }
}
