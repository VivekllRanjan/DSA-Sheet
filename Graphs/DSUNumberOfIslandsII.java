package Graphs;

import java.util.*;

public class DSUNumberOfIslandsII {
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1); // -1 means water
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        void makeSet(int i) {
            parent[i] = i;
            rank[i] = 0;
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return;

            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pv] < rank[pu]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
    final int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        DSU dsu = new DSU(m * n);
        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for(int[] pos : positions){
            int r = pos[0], c = pos[1];

            if(vis[r][c]) {
                ans.add(count);
                continue;
            }

            int idx = r * n + c;
            dsu.makeSet(idx);
            vis[r][c] = true;
            count++;

            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >=0 && nc >=0 && nr < m && nc < n) {
                    if(vis[nr][nc]) {
                        int adjIdx = nr * n + nc;
                        if(dsu.find(idx) != dsu.find(adjIdx)) {
                            count--;
                            dsu.union(idx, adjIdx);
                        }
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }


    // Optional: test driver
    public static void main(String[] args) {
        DSUNumberOfIslandsII solution = new DSUNumberOfIslandsII();
        DSUNumberOfIslandsII.DSU inner = solution.new DSU(9); // Not used directly

        int m = 3, n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        List<Integer> result = solution.numIslands2(m, n, positions);
        System.out.println(result); // Output: [1, 1, 2, 3]
    }
}
