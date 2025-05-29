package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    private int ROW, COL;
    private final int[][] direction = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public int[][] updateMatrix(int[][] mat) {
        ROW = mat.length;
        COL = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (mat[r][c] == 0) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        int dist = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                mat[r][c] = dist;

                for(int[] dir : direction) {
                    int nR = r + dir[0];
                    int nC = c + dir[1];

                    if(nR >=0 && nC >=0 && nR < ROW && nC < COL && !visited[nR][nC]) {
                        visited[nR][nC] = true;;
                        q.offer(new int[] {nR, nC});
                    }
                }
            }
            dist++;
        }

        return mat;
    }

}
