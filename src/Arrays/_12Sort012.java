package Arrays;
/*
SORT ARRAY OF 0s, 1s, AND 2s

Given an array nums consisting only of 0s, 1s, and 2s,
sort the array in-place without using any sorting algorithm.

Example:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Constraints:
- 1 <= nums.length <= 300
- nums[i] is either 0, 1, or 2

Approach:
- Use Dutch National Flag Algorithm
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

public class _12Sort012 {
    public static void sort012(int nums[]){
        int low=0;
        int mid = 0;
        int high=nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if (nums[mid]==1){
                mid++;
            }else{
                swap(nums,high,mid);
                high--;
            }
        }
    }
    public static void swap(int nums[],int start,int end){
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        int arr[]={0,1,2,0,1,0,2,2,1,0};
        sort012(arr);
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i] + ",");
            }
        }

    }
}
