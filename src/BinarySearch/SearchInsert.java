package BinarySearch;
/*
 Problem Statement:
 Given a sorted array of distinct integers and a target value,
 return the index if the target is found.
 If not, return the index where it would be inserted in order.

 The array is sorted in ascending order.
 The solution must run in O(log n) time.

 Example:
 Input: nums = [1, 3, 5, 6], target = 2
 Output: 1

 Input: nums = [1, 3, 5, 6], target = 7
 Output: 4
*/

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(target==nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        SearchInsert obj = new SearchInsert();

        int[] nums = {1, 3, 5, 6};

        System.out.println(obj.searchInsert(nums, 5)); // Output: 2
        System.out.println(obj.searchInsert(nums, 2)); // Output: 1
        System.out.println(obj.searchInsert(nums, 7)); // Output: 4
        System.out.println(obj.searchInsert(nums, 0)); // Output: 0
    }


}
