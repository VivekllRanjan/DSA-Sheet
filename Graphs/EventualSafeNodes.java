package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        boolean[] visited = new boolean[nodes];
        boolean[] path = new boolean[nodes];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nodes; i++) {
            if(!isCyclic(i, graph, visited, path, result)) {
                result.add(i);
            }
        }
        Collections.sort(result);
        return result;
    }

    private boolean isCyclic(int node, int[][] graph, boolean[] visited, boolean[] path, List<Integer> result) {
        if (path[node]) return true; // Detected cycle
        if (visited[node]) return false; // No cycle

        visited[node] = true;
        path[node] = true;

        for(int nei : graph[node]) {
            if(isCyclic(nei, graph, visited, path, result)) {
                return true;
            }
        }

        path[node] = false;
        return false;
    }
}
