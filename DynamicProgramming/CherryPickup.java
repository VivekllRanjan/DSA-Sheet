package DynamicProgramming;

public class CherryPickup {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new Integer[n][n][n];
        return Math.max(0, counter(grid, 0, 0, 0, n));
    }

    private int counter(int[][] grid, int r1, int c1, int r2, int n) {
        int c2 = r1 + c1 - r2;
        if(r1 >=n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] ==-1)
            return Integer.MIN_VALUE;

        if (dp[r1][c1][r2] != null)
            return dp[r1][c1][r2];

        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];

        int cherries;
        //If both are at same cell
        if(r1 == r2 && c1 == c2) cherries = grid[r1][c1];

        else cherries = grid[r1][c1] + grid[r2][c2];

        // DD,DR,RD,RR
        int best = Math.max(
                Math.max(
                        counter(grid, r1 + 1, c1, r2 + 1, n),
                        counter(grid, r1 + 1, c1, r2, n)),
                Math.max(
                        counter(grid, r1, c1 + 1, r2 + 1, n),
                        counter(grid, r1, c1 + 1, r2, n))
        );

        if(best == Integer.MIN_VALUE) {
            dp[r1][c1][r2] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }
        cherries += best;
        return dp[r1][c1][r2] = cherries;
    }
}
