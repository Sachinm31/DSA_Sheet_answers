package BinarySearch.BS;

/*
PROBLEM STATEMENT:
------------------
You are given a rotated sorted array that may contain duplicates.
Determine if a given target exists in the array.

This is LeetCode 81: Search in Rotated Sorted Array II.

Example:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Key Challenge:
--------------
Duplicates break the usual binary search logic.
When nums[start] == nums[mid] == nums[end], we cannot decide
which half is sorted.
*/

class SearchInRotatedArrayWithDuplicates {

    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Case 1: Target found
            if (nums[mid] == target) {
                return true;
            }

            /*
            EDGE CASE (MOST IMPORTANT):
            ---------------------------
            nums[start] == nums[mid] == nums[end]

            Example:
            nums = [2, 2, 2, 3, 2, 2]
                     s     m        e

            Here, we cannot determine which half is sorted.
            Binary search gives no information.

            Solution:
            Shrink the search space safely.
            */
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue; // restart loop with new boundaries
            }

            // Case 2: Left half is sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Case 3: Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    // MAIN METHOD FOR TESTING
    public static void main(String[] args) {

        // Edge case with duplicates
        int[] nums = {2, 2, 2, 3, 2, 2};
        int target = 3;

        boolean result = search(nums, target);

        System.out.println("Target found: " + result);
    }
}

