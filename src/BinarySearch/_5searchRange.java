package BinarySearch;
import java.util.*;
/*
Problem: Find First and Last Position of Element in Sorted Array

You are given an array of integers nums sorted in non-decreasing order,
and an integer target.

Your task is to find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
*/

public class _5searchRange {
    public static int[] searchRange(int[] nums, int target){
        int first = findFirst(nums,target);
        int second = findSecond(nums,target);

//        count occurances
        System.out.println("count :- "+ (second-first+1));

        return new int[]{first,second};
    }
    public static int findFirst(int nums[],int target){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target<=nums[mid]){
                end=mid-1;
                ans=mid;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public static int findSecond(int nums[],int target){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target>=nums[mid]){
                start=mid+1;

                ans=mid;
            }else{
                end=mid-1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result)); // Output: [3, 4]
    }
}
