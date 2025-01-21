package Array;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0}, {1, 1, 1}, {1, 1, 1}};
        int m = matrix.length;
        System.out.println(m);
        int n = matrix[0].length;
        System.out.println(n);
        int row[] = new int[m];
        int col[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < m; i++) {
            System.out.print(row[i]);

        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(col[i]);

        }
        System.out.println();
        System.out.println("Solution:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
