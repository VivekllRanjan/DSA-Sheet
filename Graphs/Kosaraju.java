package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Kosaraju {
    public void dfs1(int node, boolean[] vis, List<List<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;
        for(int nei : adj.get(node)) {
            if(!vis[nei]){
                dfs1(nei, vis, adj, st);
            }
        }
        st.push(node);
    }

    public void dfs2(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(int nei : adj.get(node)) {
            if(!vis[nei]) {
                dfs2(nei, adj, vis);
            }
        }
    }

    public int kosaraju(int n, List<List<Integer>> adj) {
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        //Add all nodes to stack acc/ to finising time of dfs
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs1(i, vis, adj, st);
            }
        }

        //Reverse the graph
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < n; i++) revAdj.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            vis[i] = false;
            for(int nei : adj.get(i)) {
                revAdj.get(nei).add(i);
            }
        }

        int count = 0;
        while(!st.isEmpty()) {
            int node = st.pop();
            if(!vis[node]) {
                count++;
                dfs2(node, revAdj, vis);
            }
        }

        return count;
    }
}
