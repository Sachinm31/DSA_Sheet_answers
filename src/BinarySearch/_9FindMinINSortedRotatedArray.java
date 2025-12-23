package BinarySearch;
/*
------------------------------------------------------------
Problem: Find Minimum in Rotated Sorted Array
------------------------------------------------------------

You are given an integer array `nums` of length `n` that was
originally sorted in strictly increasing order, but was
rotated between 1 and n times.

For example:
Original sorted array:
[0, 1, 2, 4, 5, 6, 7]

Possible rotations:
[4, 5, 6, 7, 0, 1, 2]
[7, 0, 1, 2, 4, 5, 6]

Task:
Return the minimum element in the array.

Constraints:
- 1 ≤ nums.length ≤ 10^5
- All elements are unique
- The array is rotated at some pivot (unknown)
- The algorithm must run in O(log n) time

Approach (Binary Search):
- If the array is already sorted, the first element is the minimum.
- Otherwise, use binary search to locate the unsorted (rotated) part.
- Compare nums[mid] with nums[end]:
    • If nums[mid] > nums[end], the minimum lies in the right half.
    • Else, the minimum lies in the left half (including mid).
- Continue shrinking the search space until start == end.

Return nums[start] as the minimum element.

Example:
Input:  nums = [4,5,6,7,0,1,2]
Output: 0
------------------------------------------------------------
*/

public class _9FindMinINSortedRotatedArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // Binary Search
        while (start < end) {
            int mid = start + (end - start) / 2;

            // Minimum lies in right half
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
            // Minimum lies in left half (including mid)
            else {
                end = mid;
            }
        }
        // start == end → minimum element
        return nums[start];
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {3, 4, 5, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Minimum element: " + findMin(nums1)); // 0
        System.out.println("Minimum element: " + findMin(nums2)); // 1
        System.out.println("Minimum element: " + findMin(nums3)); // 11
    }
}
