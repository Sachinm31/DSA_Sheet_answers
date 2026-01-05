package SlidingWindow.Type3;

/*
 Problem Statement (LeetCode 42: Trapping Rain Water)
 ---------------------------------------------------
 You are given an array height[] where each element represents
 the height of a vertical bar.

 After raining, water can be trapped between the bars.
 Your task is to calculate the total amount of trapped water.

 Key Formula:
 water at index i = min(maxLeft, maxRight) - height[i]

 Constraints:
 - Bars have width = 1
 - You cannot tilt the bars
 - Return total trapped water

 Example:
 Input:  height = [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6

 Approach:
 ---------
 Two Pointer Technique (Optimized)

 Maintain:
 - left pointer and right pointer
 - leftMax = maximum height seen so far from left
 - rightMax = maximum height seen so far from right

 Logic:
 - If height[left] <= height[right]:
     - Water is limited by leftMax
     - Update leftMax or add water
     - Move left++
 - Else:
     - Water is limited by rightMax
     - Update rightMax or add water
     - Move right--

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class _5TrappingRainWater {

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        int result = trap(height);

        System.out.println("Trapped Water: " + result);
        // Expected Output: 6
    }
}
