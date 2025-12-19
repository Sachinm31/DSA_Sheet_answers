package Arrays;
/*
 * LeetCode 2149 - Rearrange Array Elements by Sign
 *
 * Problem Statement:
 * You are given a 0-indexed integer array nums of even length
 * consisting of an equal number of positive and negative integers.
 *
 * Rearrange the array such that:
 * 1. The array starts with a positive integer.
 * 2. Positive and negative numbers alternate.
 * 3. The relative order of positive numbers is preserved.
 * 4. The relative order of negative numbers is preserved.
 *
 * Return the rearranged array.
 *
 * Example:
 * Input:  nums = [3, 1, -2, -5, 2, -4]
 * Output: [3, -2, 1, -5, 2, -4]
 *
 * Constraints:
 * - 2 <= nums.length <= 2 * 10^5
 * - nums.length is even
 * - Equal number of positive and negative integers
 */

public class _17RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int odd=1;
        int even = 0;

        int arr[]=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                arr[even]=nums[i];
                even+=2;
            }else{
                arr[odd]=nums[i];
                odd+=2;
            }
        }
        return arr;
    }
    public static void main(String[] args) {

        _17RearrangeArray obj = new _17RearrangeArray();

        int[] nums = {3, 1, -2, -5, 2, -4};

        int[] result = obj.rearrangeArray(nums);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
