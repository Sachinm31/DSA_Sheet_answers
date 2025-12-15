package Arrays.DSASheet;
import java.util.HashMap;
/*
TWO SUM – PROBLEM STATEMENT

Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input has exactly one solution,
and you may not use the same element twice.

The answer can be returned in any order.

Example:
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation:
nums[0] + nums[1] = 2 + 7 = 9

Constraints:
- 2 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9

Approach:
- Use HashMap to store (value → index)
- For each element, check if (target - current) exists
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

public class _11TwoSum {
    public static int[] twoSum(int nums[],int target){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int comp = target-nums[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,10};
        int k = 15;

        int ans[] = twoSum(nums,k);
        System.out.println(ans[0] + " " + ans[1]);

    }
}
