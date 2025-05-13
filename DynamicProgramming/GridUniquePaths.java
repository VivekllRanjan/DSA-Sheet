package DynamicProgramming;

import java.util.Arrays;

public class GridUniquePaths {
    private int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }

        return count(m-1,n-1,dp);
    }

    private int count(int m ,int n, int[][] dp) {

        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        //Move down(Bottom up -> Move top)
        int dw = count(m-1, n, dp);
        //Mode right(Bottom up -> Move left)
        int rg = count(m, n-1, dp);

        return dp[m][n] = dw + rg;
    }

    private int uniquePathsTabArray(int m, int n) {

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[0][0] = 1;
                else {
                    int up = (i > 0) ? dp[i-1][j] : 0;
                    int left = (j > 0) ? dp[i][j-1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    private int uniquePathsTabulation(int m, int n) {

        int[] prev = new int[n]; //prev row

        for(int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) curr[j] = 1;
                else {
                    int down = (i > 0) ? prev[j] : 0;
                    int right = (j > 0) ? curr[j-1] : 0;
                    curr[j] = down + right;
                }
            }
            prev = curr;
        }

        return prev[n-1];
    }
}
