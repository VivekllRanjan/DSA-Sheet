package Graphs;

public class CyclingDirectionalGraph {
    public boolean isCyclicDirectional(int[][] adj) {
        int nodes = adj.length;
        boolean[] visited = new boolean[nodes];
        boolean[] path = new boolean[nodes];

        for(int i = 0; i < nodes; i++) {
            if(!visited[i] && dfs(i, adj, visited, path)) {
                return true;
            }
        }

        return false;
    }
    private boolean dfs(int node, int[][] adj, boolean[] visited, boolean[] path) {
        visited[node] = true;
        path[node] = true;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, path)) {
                    return true;
                }
            } else if (path[neighbor]) {
                return true; // cycle found
            }
        }
        path[node] = false;
        return false;
    }

}
