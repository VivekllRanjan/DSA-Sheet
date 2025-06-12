package Graphs;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    public int[] bellmanFord(int n, List<List<Integer>> edges, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 0; i < n -1; i++) {
            boolean updated = false;
            for (List<Integer> e : edges) {
                int u = e.get(0);
                int v = e.get(1);
                int d = e.get(2);

                if (dist[u] != Integer.MAX_VALUE && dist[u] + d < dist[v]) {
                    dist[v] = dist[u] + d;
                    updated = true;
                }
            }
            if (!updated) break;
        }
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int d = e.get(2);

            if (dist[u] != Integer.MAX_VALUE && dist[u] + d < dist[v]) {
                return new int[] {-1};
            }
        }

        return dist;
    }
}
