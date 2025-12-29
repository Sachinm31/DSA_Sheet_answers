package BinarySearch.BS2DArrsy;

public class _2SearchInSorted2DArray {

    public static boolean search(int nums[][], int target) {
        int i = 0;
        int j = nums[0].length - 1;

        // Start from top-right corner
        while (j >= 0 && i < nums.length) {

            if (nums[i][j] == target) {
                return true;
            }
            else if (target > nums[i][j]) {
                i++;        // move down
            }
            else {
                j--;        // move left
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,  4,  7,  11},
                {2,  5,  8,  12},
                {3,  6,  9,  16},
                {10, 13, 14, 17}
        };

        int target = 6;

        boolean result = search(matrix, target);

        System.out.println("Target found: " + result);
    }
}
