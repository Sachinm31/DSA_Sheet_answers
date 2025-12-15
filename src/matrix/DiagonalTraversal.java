package matrix;

public class DiagonalTraversal {

    public static void diagonalPrint(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // First half diagonals (starting from top row)
        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0;
            int c = startCol;

            while (r < rows && c >= 0) {
                System.out.print(matrix[r][c] + " ");
                r++;
                c--;
            }
            System.out.println();
        }

        // Second half diagonals (starting from last column of remaining rows)
        for (int startRow = 1; startRow < rows; startRow++) {
            int r = startRow;
            int c = cols - 1;

            while (r < rows && c >= 0) {
                System.out.print(matrix[r][c] + " ");
                r++;
                c--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3 },
                { 4,  5,  6 },
                { 7,  8,  9 }
        };

        diagonalPrint(matrix);
    }
}
