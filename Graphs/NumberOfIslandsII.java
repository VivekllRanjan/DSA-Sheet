package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslandsII {
    private int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private int row, col;

    public int countDistinctIslands(int[][] grid) {

        row = grid.length;
        col = grid[0].length;
        Set<String> shapes = new HashSet<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    List<String> shape = new ArrayList<>();
                    dfs(i, j, i, j, shape, grid);
                    String strShape = String.join(",", shape);
                    shapes.add(strShape);
                }
            }
        }

        return shapes.size();
    }

    private void dfs(int r, int c, int baseR, int baseC, List<String> shape, int[][] grid) {
        if(r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0; //visited
        shape.add((r - baseR) + ":" + (c - baseC));

        for(int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], baseR, baseC, shape, grid);
        }
    }
}
