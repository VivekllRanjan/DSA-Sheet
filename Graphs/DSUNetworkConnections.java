package Graphs;

public class DSUNetworkConnections {
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
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) {
                return false;
            }

            if(rank[pu] < rank[pv]) {
                parent[pu] = pv;
            }
            else if(rank[pv] < rank[pu]) {
                parent[pv] = pu;
            }
            else {
                parent[pv] = pu;
                rank[pu]++;
            }

            return true;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;

        DSU dsu = new DSU(n);

        int components = n;
        for(int[] c : connections) {
            if(dsu.union(c[0], c[1])){
                components--;
            }
        }

        return components - 1;
    }
}
