package Graphs;

import java.util.Arrays;

public class CityWithSmallestNei {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        int[][] adj = new int[n][n];
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int d = e[2];

            dist[u][v] = d;
            dist[v][u] = d;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n ; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            &&dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Now, find the city with minimum reachable neighbors
        int minReachable = Integer.MAX_VALUE;
        int resultCity = -1;

        for(int i = 0; i < n; i++) {
            int rechableCount = 0;
            for(int j = 0; j < n; j++) {
                if(i != j && dist[i][j] <= distanceThreshold) {
                    rechableCount++;
                }
            }

            if(rechableCount < minReachable || (rechableCount == minReachable && i > resultCity)){
                minReachable = rechableCount;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
