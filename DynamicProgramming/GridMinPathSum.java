package DynamicProgramming;

import java.util.Arrays;

public class GridMinPathSum {
    private int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return calSum(grid, m - 1, n - 1, dp);
    }

    private int calSum(int[][] grid, int m, int n, int[][] dp) {
        if(m == 0 && n == 0) return grid[0][0];
        if(m < 0 || n < 0) return Integer.MAX_VALUE;

        if(dp[m][n] != -1) return dp[m][n];

        int up = calSum(grid, m - 1, n, dp);
        int left = calSum(grid, m, n - 1, dp);
        dp[m][n] = grid[m][n] + Math.min(up, left);

        return dp[m][n];
    }


    private int minPathSumTabulozed(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];

        for(int i = 0;i < m; i++) {
            int[] curr = new int[n];
            for(int j = 0;j < n;j++) {
                if(i == 0 && j == 0) curr[j] = grid[0][0];
                else {
                    int up   = i > 0 ? prev[j] : Integer.MAX_VALUE;
                    int left = j > 0 ? curr[j - 1] : Integer.MAX_VALUE;
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[n-1];
    }
}
