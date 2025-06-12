package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalMST {
    static class Edge implements Comparable<Edge> {
        int u, v, wt;
        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Edge other) {
            return this.wt - other.wt;
        }
    }

    static class DSU {
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

            if (pu == pv) return false; // They are already in the same set

            if(rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if(rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }

            return true;
        }

        public static int kruskal(int n, List<Edge> edges) {
            Collections.sort(edges);
            DSU dsu = new DSU(n);

            int mstWeight = 0;
            List<Edge> mstEdges = new ArrayList<>();

            for(Edge e : edges) {
                if(dsu.union(e.u, e.v)) {
                    mstWeight += e.wt;
                    mstEdges.add(e);
                    if (mstEdges.size() == n - 1) break;
                }
            }

            return mstWeight;
        }
    }
}
