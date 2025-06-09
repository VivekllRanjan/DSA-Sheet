package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSShortestPath {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];
        for(int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()) {
            int curr = q.poll();
            int d = dist[curr];
            for(int nei : adj.get(curr)) {
                if(dist[nei] > d + 1) {
                    dist[nei] = d + 1;
                    q.offer(nei);
                }
            }
        }

        return dist;
    }
}
