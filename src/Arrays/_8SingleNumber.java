package Arrays;
import java .util.HashMap;
import java.util.Map;
/*
Problem: Single Number

Given a non-empty array of integers nums, every element appears twice except for one.
Find and return that single one.

Example:
Input: nums = [4,1,2,1,2]
Output: 4

Constraints:
- 1 <= nums.length <= 3 * 10^4
- Each element appears exactly twice except one element
- Use linear time complexity

Follow-up:
Can you implement a solution using constant extra space?
*/

public class _8SingleNumber {
    // Function 1: Using HashMap
    public static int singleNumberUsingMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // Function 2: Optimal XOR approach
    public static int singleNumberUsingXOR(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    // Main method
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        System.out.println("Using HashMap: " + singleNumberUsingMap(nums));
        System.out.println("Using XOR: " + singleNumberUsingXOR(nums));
    }
}
