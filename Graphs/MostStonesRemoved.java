package Graphs;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemoved {
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return;

            if(rank[pu] < rank[pv]) parent[pu] = pv;
            else if(rank[pv] < rank[pu]) parent[pv] = pu;
            else { parent[pv] = pu; rank[pu]++; }
        }
    }
    public int removeStones(int[][] stones) {
        int maxR = 0, maxC = 0;
        for(int[] stone : stones){
            maxR = Math.max(maxR, stone[0]);
            maxC = Math.max(maxC, stone[1]);
        }
        DSU dsu = new DSU(maxR + maxC + 2);

        //Union each r & c according to each stone position
        for(int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxR + 1;
            dsu.union(row, col);
        }

        Set<Integer> uniqueParents = new HashSet<>();
        for (int[] stone : stones) {
            uniqueParents.add(dsu.find(stone[0]));
        }

        return stones.length - uniqueParents.size();
    }
}
