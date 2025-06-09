package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        int[] parent = new int[n];
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        dist[0] = 0;
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dis = curr[1];

            for(int[] nei : adj.get(node)) {
                int adjNode = nei[0];
                int edW = nei[1];
                if(dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    parent[adjNode] = node;
                    pq.add(new int[]{adjNode, dis + edW});
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if(dist[n - 1] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        int curr = n - 1;
        while(parent[curr] != curr) {
            path.add(curr);
            curr = parent[curr];
        }
        path.add(0);
        Collections.reverse(path);

        return path;
    }
}
