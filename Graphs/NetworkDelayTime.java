package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Build adj list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];

            adj.get(u).add(new int[] {v, t});
        }

        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        time[k] = 0;
        pq.add(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int u = curr[1];

            if (currTime > time[u]) continue;

            for(int[] nei : adj.get(u)){
                int v = nei[0];
                int newTime = currTime + nei[1];

                if(time[v] > newTime) {
                    time[v] = newTime;
                    pq.add(new int[] {newTime, v});
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            if (time[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, time[i]);
        }

        return max;
    }
}
