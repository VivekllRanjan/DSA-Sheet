package Graphs;

import java.util.*;

public class AccountMerge {
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);  // Path compression
            }
            return parent[x];
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return;

            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> details) {
        int n = details.size();
        DSU ds = new DSU(n);
        HashMap<String, Integer> emailToAccountIndex = new HashMap<>();

        // Step 1: Union accounts based on shared emails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String email = details.get(i).get(j);
                if (!emailToAccountIndex.containsKey(email)) {
                    emailToAccountIndex.put(email, i);
                } else {
                    ds.union(i, emailToAccountIndex.get(email));
                }
            }
        }

        // Step 2: Group emails by their root representative
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : emailToAccountIndex.entrySet()) {
            String email = entry.getKey();
            int rootIndex = ds.find(entry.getValue());
            mergedMail[rootIndex].add(email);
        }

        // Step 3: Prepare final answer
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));  // Account name
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }

        return ans;
    }
}
