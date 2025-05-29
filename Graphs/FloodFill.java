package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    private int ROW, COL;
    private final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        ROW = image.length;
        COL = image[0].length;
        int scolor = image[sr][sc];
        if (scolor == color) return image;
        dfs(image, sr, sc, scolor, color);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int scolor, int color) {
        image[sr][sc] = color;
        for (int[] dir : direction) {
            int nR = sr + dir[0];
            int nC = sc + dir[1];
            if (nR >= 0 && nC >= 0 && nR < ROW && nC < COL && image[nR][nC] == scolor) {
                dfs(image, nR, nC, scolor, color);
            }
        }
    }
    private void bfs(int[][] image, int sr, int sc, int scolor, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc});
        image[sr][sc] = color;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for(int[] dir : direction) {
                int nR = r + dir[0];
                int nC = c + dir[1];
                if(nR >= 0 && nC >=0 && nR < ROW && nC < COL && image[nR][nC] == scolor) {
                    q.offer(new int[] {nR, nC});
                    image[nR][nC] = color;
                }
            }
        }
    }
}
