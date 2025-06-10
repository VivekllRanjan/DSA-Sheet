package Graphs;

import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    public int[][] floydWarshall(int n, List<List<Integer>> edges) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0; // Distance to self is 0
        }

        for(List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int d = e.get(2);

            dist[u][v] = d;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            &&dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                // Negative cycle found
                return new int[][]{};
            }
        }

        return dist;
    }
}
