package DynamicProgramming;

public class CherryPickupII {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new Integer[n][m][m];
        return helper(grid, n, m, 0, 0, m - 1);
    }

    private int helper(int[][] grid, int n, int m, int row, int c1, int c2) {

        if (c1 < 0 || c1 >= m || c2 < 0 || c2 >= m)
            return 0;

        if (row == n)
            return 0;
        if(dp[row][c1][c2] != null) return dp[row][c1][c2];
        int cherries;

        if (c1 == c2)
            cherries = grid[row][c1];
        else
            cherries = grid[row][c1] + grid[row][c2];

        //left, down, right ==> LL, LD, LR, DL, DD, DR, RL, RD, RR
        int best = 0;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                best = Math.max(best,
                        helper(grid, n, m, row + 1, c1 + d1, c2 + d2));
            }
        }
        cherries += best;
        return dp[row][c1][c2] = cherries;
    }
}
