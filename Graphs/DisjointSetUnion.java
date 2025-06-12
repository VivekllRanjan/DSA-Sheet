package Graphs;

public class DisjointSetUnion {

    int[] parent, rank;

    public DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];

        // Initially, each element is its own parent, and rank is 0
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int find(int n) {
        if(parent[n] != n) {
            parent[n] = find(parent[n]);
        }

        return parent[n];
    }

    private void union(int u , int v) {
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;  // Increase only when both are equal
        }
    }

    // Utility to print parent array
    public void printParents() {
        System.out.print("Parent array: ");
        for (int i = 0; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    // Utility to check if two elements are in the same set
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    // Driver code to test DSU
    public static void main(String[] args) {
        int n = 5; // 0 to 4
        DisjointSetUnion dsu = new DisjointSetUnion(n);

        dsu.union(0, 1);
        dsu.union(2, 3);
        dsu.union(0, 2);
        dsu.union(4, 3);

        dsu.printParents();

        System.out.println("Is 0 connected to 4? " + dsu.isConnected(0, 4));
        System.out.println("Is 1 connected to 3? " + dsu.isConnected(1, 3));
        System.out.println("Is 1 connected to 4? " + dsu.isConnected(1, 4));
        System.out.println("Is 1 connected to 2? " + dsu.isConnected(1, 2));
    }
}
