package Graphs;

import java.util.*;

public class OceansFlow {
    class Solution {
        private int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int ROW = heights.length, COL = heights[0].length;
            boolean[][] pac = new boolean[ROW][COL];
            boolean[][] atl = new boolean[ROW][COL];

            for(int i = 0; i < COL; i++){
                dfs(0, i, pac, heights);
                dfs(ROW - 1, i , atl, heights);
            }

            for(int j = 0; j < ROW; j++){
                dfs(j, 0, pac, heights);
                dfs(j, COL - 1, atl, heights);
            }

            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < ROW; i++) {
                for(int j = 0; j < COL; j++) {
                    if(pac[i][j] && atl[i][j]) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }

            return res;
        }

        private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
            ocean[r][c] = true;
            for(int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < heights.length &&
                        nc >= 0 && nc < heights[0].length &&
                        !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    dfs(nr, nc, ocean, heights);
                }
            }
        }
    }


    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for (int c = 0; c < COLS; c++) {
            pacQueue.add(new int[]{0, c});
            atlQueue.add(new int[]{ROWS - 1, c});
        }
        for (int r = 0; r < ROWS; r++) {
            pacQueue.add(new int[]{r, 0});
            atlQueue.add(new int[]{r, COLS - 1});
        }

        bfs(pacQueue, pac, heights);
        bfs(atlQueue, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < heights.length && nc >= 0 &&
                        nc < heights[0].length && !ocean[nr][nc] &&
                        heights[nr][nc] >= heights[r][c]) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
