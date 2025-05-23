package Graphs;

public class MaxAreaOfIsland {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length, col = grid[0].length;
        int area = 0;

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 1){
                    area = Math.max(area, dfs(grid, r, c));
                }
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0; //Visited
        int area =1;

        for(int[] dir : directions) {
            area += dfs(grid, r + dir[0], c + dir[1]);
        }

        return area;
    }
}
