package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int islands = 0;

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0'; //Visited

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private void bfs(char[][] grid, int sR, int sC) {
        int row = grid.length, col = grid[0].length;

        grid[sR][sC] = '0';
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sR, sC});

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            for(int[] dir : directions) {
                int newR = currR + dir[0];
                int newC = currC + dir[1];

                if(newR >= 0 && newC >=0 && newR < row && newC < col && grid[newR][newC] == '1'){
                    q.offer(new int[] {newR, newC});
                    grid[newR][newC] = '0';
                }
            }
        }
    }
}
