package Graphs;

import java.util.*;

public class CheapestFlightKStops {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<int[]>> adj = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                adj.get(from).add(new int[]{to, price});
            }

            //BFS q -> currNode, currCost, stopsUsed
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{src, 0 , 0});

            int[][] cost = new int[n][k + 2];
            for(int i = 0; i < n; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            cost[src][0] = 0;

            int result = Integer.MAX_VALUE;
            while(!q.isEmpty()) {
                int[] curr = q.poll();
                int node = curr[0];
                int costSoFar = curr[1];
                int stops = curr[2];

                if(node == dst) {
                    result = Math.min(result, costSoFar);
                    continue;
                }
                if(stops > k) continue;

                for(int[] nei : adj.get(node)) {
                    int next = nei[0];
                    int newCost = costSoFar + nei[1];
                    int newStops = stops + 1;

                    if(newStops <= k + 1 && newCost < cost[next][newStops]) {
                        cost[next][newStops] = newCost;
                        q.offer(new int[] {next, newCost, newStops});
                    }
                }
            }

            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }
}
