package BinarySearch.BS;

public class _13FindLowerBound {

    /*
    ====================================================
    PROBLEM STATEMENT:
    ----------------------------------------------------
    Given a sorted array `nums` and a target value,
    find the index of the first element in the array
    which is GREATER THAN OR EQUAL TO the target.

    This index is called the LOWER BOUND.

    If all elements in the array are smaller than the
    target, return nums.length.

    ----------------------------------------------------
    Example:
    nums   = [1, 2, 4, 4, 5, 7]
    target = 4

    Output = 2
    (nums[2] = 4 is the first element >= 4)
    ----------------------------------------------------
    Time Complexity  : O(log n)
    Space Complexity : O(1)
    ====================================================
    */

    public static int lowerBound(int[] nums, int target) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;

        // If target is greater than the largest element
        if (target > nums[end]) return n;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // ------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------
    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 4, 5, 7};

        int target1 = 4;
        int target2 = 6;
        int target3 = 0;
        int target4 = 8;

        System.out.println("Lower Bound of 4 : " + lowerBound(nums, target1)); // 2
        System.out.println("Lower Bound of 6 : " + lowerBound(nums, target2)); // 5
        System.out.println("Lower Bound of 0 : " + lowerBound(nums, target3)); // 0
        System.out.println("Lower Bound of 8 : " + lowerBound(nums, target4)); // 6
    }
}
