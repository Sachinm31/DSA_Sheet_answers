package Arrays.Sorting;
/*
Problem: Find the Missing Number in an Array

Given an array nums containing n distinct numbers taken from the range [0, n],
find and return the one number that is missing from the array.

Example:
Input: nums = [3, 0, 1]
Output: 2

Explanation:
The numbers are from 0 to 3. Since 2 is missing, return 2.

Constraints:
- n == nums.length
- 1 <= n <= 10^4
- 0 <= nums[i] <= n
- All numbers in nums are unique

Note:
The solution should run


 */
public class _7findMissingNumber {
    public static int missingNumber(int nums[]){
        int n = nums.length;
        int sum=0;

        for(int i=0;i<=n;i++){
            sum+=i;
        }
        for(int i=0;i<n;i++){
            sum-=nums[i];
        }
        return sum;
    }

    public static int missingNumberXOR(int[] nums) {
        int xor = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }
        return xor ^ n;
    }
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};

        int missing = missingNumber(nums);
        System.out.println("Missing number is: " + missing);
    }
}
