package Graphs;

import java.util.Arrays;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int colors[] = new int[nodes];
        Arrays.fill(colors, -1);

        for(int i = 0; i < nodes; i++) {
            if(colors[i] == -1 && !dfs(i, graph, 0, colors)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int[][] graph, int clr, int[] color) {
        color[node] = clr;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, graph, 1 - clr, color)) return false;
            }
            else if (color[neighbor] == clr) {
                return false;
            }
        }

        return true;
    }
}
