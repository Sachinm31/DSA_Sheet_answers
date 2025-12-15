package Arrays;

import java.util.HashMap;
/*
MAJORITY ELEMENT

Given an array nums of size n, return the majority element.

The majority element is the element that appears
more than ⌊n / 2⌋ times.

You may assume that the majority element always exists
in the array.

Example:
Input: nums = [3,2,3]
Output: 3

Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
- n == nums.length
- 1 <= n <= 5 * 10^4
- -10^9 <= nums[i] <= 10^9

Approach:
- Use Moore’s Voting Algorithm
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

public class _13MajorityElement {
    public static int majorityElement(int arr[]) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int  n = arr.length;

        for(int i = 0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(int num:arr){
            if(map.get(num)>n/2){
                return num;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 3,3,3,3,3,3,3,3,3,3,3,1, 2, 2};
        System.out.println(majorityElement(nums)); // 2
    }
}
