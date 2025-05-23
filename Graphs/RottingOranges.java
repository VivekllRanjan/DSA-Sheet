package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private final int[][] directions = { {-1,0} , {1,0} , {0,-1} , {0,1} };

    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int res = bfs(grid, q, fresh);

        return res;
    }

    private int bfs(int[][] grid, Queue<int[]> q, int fresh) {
        int row = grid.length, col = grid[0].length;
        if (fresh == 0) return 0;
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int currR = curr[0];
                int currC = curr[1];

                //Get neighbour
                for(int[] dir : directions) {
                    int newR = currR + dir[0];
                    int newC = currC + dir[1];

                    //Check if that position is valid
                    if(newR < 0 || newC < 0 || newR >= row || newC >= col ||
                            grid[newR][newC] != 1){
                        continue;
                    }
                    //Rot and enqueue for next neighbours
                    grid[newR][newC] = 2;
                    q.offer(new int[] {newR,newC});
                    fresh--;
                }
            }
        }
        return fresh == 0 ? count - 1 : -1;
    }
}
