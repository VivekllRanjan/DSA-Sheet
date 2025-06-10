package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    static class Cell {
        int x,y,effort;
        Cell(int x, int y, int effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }
    }

    private final int[][] direction = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        int[][] effort = new int[n][m];
        for (int[] row : effort)
            Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;
        pq.offer(new Cell(0, 0, 0));

        while(!pq.isEmpty()) {
            Cell curr = pq.poll();

            if(curr.x == n - 1 && curr.y == m - 1) {
                return curr.effort;
            }

            for(int[] dir : direction) {
                int nx = curr.x + dir[0];
                int ny = curr.y + dir[1];

                if(nx >= 0 && nx < n && ny >=0 && ny < m) {
                    int currEffort = Math.max(curr.effort,
                            Math.abs(heights[curr.x][curr.y] - heights[nx][ny]));

                    if (currEffort < effort[nx][ny]) {
                        effort[nx][ny] = currEffort;
                        pq.offer(new Cell(nx, ny, currEffort));
                    }
                }
            }
        }
        return 0;
    }
}
