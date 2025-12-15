package matrix;

public class SpiralTraversal {

    public static void spiralPrint(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // 1. Left → Right (top row)
            for (int col = left; col <= right; col++) {
                System.out.print(matrix[top][col] + " ");
            }
            top++;  // move boundary down

            // 2. Top → Bottom (rightmost column)
            for (int row = top; row <= bottom; row++) {
                System.out.print(matrix[row][right] + " ");
            }
            right--;  // move boundary left

            if (top <= bottom) {
                // 3. Right → Left (bottom row)
                for (int col = right; col >= left; col--) {
                    System.out.print(matrix[bottom][col] + " ");
                }
                bottom--;  // move boundary up
            }

            if (left <= right) {
                // 4. Bottom → Top (leftmost column)
                for (int row = bottom; row >= top; row--) {
                    System.out.print(matrix[row][left] + " ");
                }
                left++;  // move boundary right
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12}
        };

        spiralPrint(matrix);
    }
}

