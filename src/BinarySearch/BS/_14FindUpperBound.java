package BinarySearch.BS;

public class _14FindUpperBound {

    /*
    ====================================================
    PROBLEM STATEMENT:
    ----------------------------------------------------
    Given a sorted array `nums` and a target value,
    find the index of the FIRST element that is
    STRICTLY GREATER than the target.

    This index is called the UPPER BOUND.

    If no such element exists, return nums.length.

    ----------------------------------------------------
    Example:
    nums   = [1, 2, 4, 4, 4, 5, 7]
    target = 4

    Output = 5
    (nums[5] = 5 is the first element > 4)
    ----------------------------------------------------
    Time Complexity  : O(log n)
    Space Complexity : O(1)
    ====================================================
    */

    public static int upperBound(int[] nums, int target) {

        int n = nums.length;

        // Search space is [0, n)
        int start = 0;
        int end = n;   // IMPORTANT: allow returning n

        while (start < end) {

            int mid = start + (end - start) / 2;

            // If mid value is <= target,
            // upper bound must be on the right side
            if (nums[mid] <= target) {
                start = mid + 1;
            }
            // If mid value is > target,
            // this index might be the answer, move left
            else {
                end = mid;
            }
        }

        // start points to first element > target
        return start;
    }

    // ------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------
    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 4, 4, 5, 7};

        System.out.println("Upper Bound of 4 : " + upperBound(nums, 4)); // 5
        System.out.println("Upper Bound of 2 : " + upperBound(nums, 2)); // 2
        System.out.println("Upper Bound of 7 : " + upperBound(nums, 7)); // 7
        System.out.println("Upper Bound of 0 : " + upperBound(nums, 0)); // 0
        System.out.println("Upper Bound of 8 : " + upperBound(nums, 8)); // 7
    }
}
