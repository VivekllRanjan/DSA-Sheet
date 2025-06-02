package Graphs;

import java.util.*;

public class TopologicalSort {

    public static List<Integer> topoSortBFS (int[][] adj) {
        int nodes = adj.length;
        int[] indegree = new int[nodes];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < nodes; i++) {
            for(int j = 0; j < adj[i].length; j++) {
                indegree[adj[i][j]]++;
            }
        }

        for(int i = 0; i < nodes; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for(int nei : adj[curr]) {
                indegree[nei]--;
                if(indegree[nei] == 0) q.offer(nei);
            }
        }

        return ans;
    }

    public static List<Integer> TopSort(int[][] adj) {
        int nodes = adj.length;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nodes];
        for(int i = 0; i < nodes; i++) {
            if(!visited[i]) dfs(i, adj, visited, stack);
        }

        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

    private static void dfs(int node, int[][] adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for(int nei : adj[node]){
            if(!visited[nei]) dfs(nei, adj, visited, stack);
        }

        stack.push(node);
    }
}
