package Graphs;
import java.util.*;
public class LargestIsland {
    class DSU {
        int[] parent, size;
        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return;
            if(size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
            else{
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }

        int getSize(int x) {
            return size[find(x)];
        }
    }


    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

        // Step 1: Union all 1s
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    for (int[] dir : dirs) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int u = r * n + c;
                            int v = nr * n + nc;
                            dsu.union(u, v);
                        }
                    }
                }
            }
        }

        //Step 2: Try flipping all 0s
        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet<>(); //To make sure we dont duplicate componenets while adding
                    int total = 1;
                    for (int[] dir : dirs) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int root = dsu.find(nr * n + nc); //find the parent union (representative of that component)
                            if (seen.add(root)) {
                                total += dsu.getSize(root);
                            }
                        }
                    }
                    max = Math.max(max, total);
                }
            }
        }

        // If no 0s were found, return size of whole grid
        if (max == 0) {
            return n * n;
        }

        return max;
    }
}
