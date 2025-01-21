package Array;

public class SetMatrixZerosOptimal {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        int m = matrix.length;
        System.out.println(m);
        int n = matrix[0].length;
        System.out.println(n);
        int row0 = 0;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;

                    if(i > 0){
                        matrix[i][0] = 0;
                    }
                    else{
                        row0 = 1;
                    }
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0){
            for(int i =0; i<m; i++){
                matrix[i][0] = 0;
            }
        }

        if (row0 == 1){
            for(int i=0; i<n;i++){
                matrix[0][i] = 0;
            }
        }
    }
}
