package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBMatrix {
    static class Cell {
        int x, y, dist;
        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private final int[][] direction = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        boolean[][] visited = new boolean[n][n];
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Cell curr = queue.poll();

            if(curr.x == n - 1 && curr.y == n - 1) return curr.dist;

            //BFS
            for(int[] dir : direction) {
                int nx = curr.x + dir[0];
                int ny = curr.y + dir[1];

                if(nx >= 0 && nx < n && ny >=0 && ny < n && grid[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.offer(new Cell(nx, ny, curr.dist + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}
