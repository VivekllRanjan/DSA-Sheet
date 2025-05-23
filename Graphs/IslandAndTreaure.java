package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandAndTreaure {
    private final int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private final int INF = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        Queue<int[]> q = new LinkedList<>();

        //Find the treasure and perform bfs on it
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }
        bfs(grid, q);
    }
    //bfs on Treasure
    private void bfs(int[][] grid, Queue<int[]> q) {
        int row = grid.length, col = grid[0].length;

        while (!q.isEmpty()) {
            //Starting from here now
            int[] curr = q.poll();
            int cR = curr[0], cC = curr[1];
            for (int[] dir : directions) {
                int newR = cR + dir[0], newC = cC + dir[1];

                //Skip non-land areas + out of bounds
                if (newR < 0 || newC < 0 || newR >= row || newC >= col ||
                        grid[newR][newC] != INF) {
                    continue;
                }

                //Update distance and enqueue
                grid[newR][newC] = grid[cR][cC] + 1;
                q.offer(new int[]{newR, newC});
            }
        }
    }
}
