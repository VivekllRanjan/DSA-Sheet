package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeInGraph {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(List<Integer> c : connections) {
            int u = c.get(0), v = c.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] timein = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, timein, low, adj, bridges);

        return bridges;
    }

    private void dfs(int node, int parent, boolean[] vis,int[] tin, int[] low, List<List<Integer>> adj, List<List<Integer>> ans) {
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;

        for(int nei : adj.get(node)) {
            if(nei == parent) continue;
            if(!vis[nei]) {
                dfs(nei, node, vis, tin, low, adj, ans);
                low[node] = Math.min(low[node], low[nei]);
                if(low[nei] > tin[node]) {
                    ans.add(Arrays.asList(nei, node));
                }
            }
            else {
                low[node] = Math.min(low[node], low[nei]);
            }
        }

    }
}
