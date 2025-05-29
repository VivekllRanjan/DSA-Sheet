package Graphs;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] grid, boolean[] visited, int city) {
        visited[city] = true;
        for(int j = 0; j < grid.length; j++) {
            if(grid[city][j] == 1 && !visited[j]){
                dfs(grid, visited, j);
            }
        }
    }
}
