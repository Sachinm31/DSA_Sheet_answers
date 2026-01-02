package BinarySearch.BS2DArrsy;

/*
PROBLEM STATEMENT:
------------------
Given a 2D matrix mat of size rows x cols, find a peak element.
A peak element is one that is greater than or equal to its
four neighbors (up, down, left, right).

You may assume:
- No two adjacent elements are equal
- A peak always exists

Return the position [row, col] of any peak element.

CONSTRAINT GOAL:
----------------
Solve the problem in O(rows * log(cols)) time.
*/

public class _4FindPeakInMatrix {

    // Static function to find peak element in 2D matrix
    public static int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int low = 0, high = cols - 1;

        // Binary Search on columns
        while (low <= high) {
            int midCol = low + (high - low) / 2;

            // Find row index of maximum element in mid column
            int maxRow = 0;
            for (int i = 0; i < rows; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            int left = (midCol > 0) ? mat[maxRow][midCol - 1] : -1;
            int right = (midCol < cols - 1) ? mat[maxRow][midCol + 1] : -1;

            // Check peak condition
            if (mat[maxRow][midCol] >= left && mat[maxRow][midCol] >= right) {
                return new int[]{maxRow, midCol};
            }
            // Move search space
            else if (left > mat[maxRow][midCol]) {
                high = midCol - 1;
            } else {
                low = midCol + 1;
            }
        }
        return new int[]{-1, -1}; // unreachable (peak always exists)
    }

    // Main method
    public static void main(String[] args) {

        int[][] matrix = {
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32}
        };

        int[] peak = findPeakGrid(matrix);

        System.out.println("Peak found at row: " + peak[0] + ", col: " + peak[1]);
        System.out.println("Peak value: " + matrix[peak[0]][peak[1]]);
    }
}
