package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    private final int[][] direction = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
    private int row, col;
    public int numEnclaves(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if(grid[i][j] == 1) {
                        grid[i][j] = 0;
                        q.offer(new int[] {i, j});
                    }
                }
            }
        }

        bfs(grid, q);
        int res = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    res++;
                }
            }
        }

        return res;
    }

    private void bfs(int[][] grid, Queue<int[]> q) {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for(int[] dir : direction) {
                int nR = r + dir[0];
                int nC = c + dir[1];

                if(nR >= 0 && nC >= 0 && nR < row && nC < col && grid[nR][nC] == 1) {
                    grid[nR][nC] = 0;
                    q.offer(new int[] {nR, nC});
                }
            }
        }
    }
}
