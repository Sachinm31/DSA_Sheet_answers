package BinarySearch;

public class _11FindSingleElement {
 /*
    ------------------------------------------------------------
    LeetCode 540: Single Element in a Sorted Array
    ------------------------------------------------------------

    Problem Statement:
    You are given a sorted integer array `nums` where:
    - Every element appears exactly twice
    - Except for one element which appears only once

    Your task is to find and return the single element.

    Constraints:
    - 1 <= nums.length <= 10^5
    - nums is sorted in ascending order
    - All elements appear exactly twice except one
    - Time complexity must be O(log n)
    - Space complexity must be O(1)

    Example:
    Input:  nums = [1,1,2,3,3,4,4,8,8]
    Output: 2

    Key Insight:
    - Before the single element, pairs start at EVEN index
    - After the single element, pairs start at ODD index
    - The single element breaks this index pattern

    Approach:
    - Use Binary Search
    - Force mid to be even
    - Compare nums[mid] with nums[mid + 1]
    - Eliminate half of the array each time
    ------------------------------------------------------------
    */

    // Static function to find the single non-duplicate element
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Ensure mid is even so it points to the first element of a pair
            if (mid % 2 == 1) {
                mid--;
            }

            // If pair is correct, single element is on the right
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            }
            // Pair is broken, single element is on the left (or at mid)
            else {
                end = mid;
            }
        }

        // start == end -> single element found
        return nums[start];
    }

    // Main method for testing
    public static void main(String[] args) {

        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};

        System.out.println("Single element: " + singleNonDuplicate(nums1)); // 2
        System.out.println("Single element: " + singleNonDuplicate(nums2)); // 10
    }
}