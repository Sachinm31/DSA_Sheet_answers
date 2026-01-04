package SlidingWindow.Type3;

/*
 Problem Statement (LeetCode 11: Container With Most Water)
 ---------------------------------------------------------
 You are given an integer array height where height[i] represents
 the height of a vertical line at index i.

 Choose two different lines such that together with the x-axis
 they form a container that holds the maximum amount of water.

 Rules:
 - You cannot tilt the container
 - The container is formed between two indices i and j (i < j)
 - Water area = min(height[i], height[j]) * (j - i)

 Example:
 Input:  height = [1,8,6,2,5,4,8,3,7]
 Output: 49

 Explanation:
 Lines at index 1 (height=8) and index 8 (height=7)
 Width = 8 - 1 = 7
 Height = min(8,7) = 7
 Area = 7 * 7 = 49

 Approach:
 ---------
 Use the Two Pointer technique.
 - Start with maximum width (left = 0, right = n-1)
 - Calculate area
 - Move the pointer pointing to the smaller height
 - Keep track of maximum area found

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class _3ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;

            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // ✅ static main method
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height)); // Expected output: 49
    }
}
