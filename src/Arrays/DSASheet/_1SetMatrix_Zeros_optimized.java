package Arrays.DSASheet;

public class _1SetMatrix_Zeros_optimized {
    public static void setZeros(int matrix[][]){
        int m= matrix.length;
        int n = matrix[0].length;

        boolean rowZero=false;
        boolean colZero=false;

        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                colZero=true;
                break;
            }
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0){
                rowZero=true;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(rowZero){
            for(int j =0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(colZero){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeros(matrix);

        // Print result
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
