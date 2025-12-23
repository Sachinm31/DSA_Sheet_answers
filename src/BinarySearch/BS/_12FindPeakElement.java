package BinarySearch.BS;
/*
====================================================
LeetCode 162 : Find Peak Element
====================================================

PROBLEM STATEMENT:
------------------
A peak element is an element that is strictly greater than its neighbors.

You are given an integer array nums where:
1) nums[i] != nums[i + 1]
2) nums[-1] = nums[n] = -∞ (imaginary boundaries)

Return the index of ANY peak element.

A solution with O(log n) time complexity is required.

----------------------------------------------------
EXAMPLE:
Input  : nums = [1, 3, 5, 7, 6, 4, 2, 8, 9, 11, 10]
Output : 3 or 9
Explanation:
7 and 11 are peak elements.
----------------------------------------------------
*/

public class _12FindPeakElement {
    public static int findPeakElement(int nums[]){
        return 1;
    }
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 6, 4, 2, 8, 9, 11, 10};

        int peakIndex = findPeakElement(nums);

        System.out.println("Peak Index  : " + peakIndex);
        System.out.println("Peak Value  : " + nums[peakIndex]);
    }
}
