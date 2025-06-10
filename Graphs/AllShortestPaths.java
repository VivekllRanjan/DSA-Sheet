package Graphs;

import java.util.*;

public class AllShortestPaths {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // Build graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        for (int[] r : roads) {
            int u = r[0], v = r[1], t = r[2];
            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0L, 0}); // {distance, node}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];

            if (d > dist[u]) continue; // skip outdated paths

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                long w = edge[1];
                long newDist = d + w;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[]{newDist, v});
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1] % MOD;
    }
}
