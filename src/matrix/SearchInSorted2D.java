package matrix;
import java.util.*;
public class SearchInSorted2D {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1; // start at top-right corner

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // move left
            } else {
                row++; // move down
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };

        int target = 6;

        if (searchMatrix(matrix, target)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}

//Top-right gives best decision spot.
//
//If current is greater than target → no need to go downward (values below are bigger) → go left.
//
//If current is smaller than target → values on left are smaller → go down.