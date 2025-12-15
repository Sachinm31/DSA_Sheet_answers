package Arrays.DSASheet;
/*
LeetCode 73: Set Matrix Zeroes

Problem Statement:
Given an m x n integer matrix, if an element is 0, set its entire row and column to 0.
You must do it in-place.

Example:
Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]

Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Constraints:
- m == matrix.length
- n == matrix[0].length
- 1 <= m, n <= 200
- -2^31 <= matrix[i][j] <= 2^31 - 1

Note:
The solution should use constant extra space.
*/

public class _1SetMatrix_Zeros_Brute {
    public static void setMatrixZero(int matrix[][]){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markRow(matrix,i);
                    markCol(matrix,j);
                }
            }
        }
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public static void markRow(int matrix[][],int i){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int j=0;j<n;j++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-1;
            }

        }
    }
    public static void markCol(int matrix[][],int j){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-1;
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setMatrixZero(matrix);

        // Print result
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
