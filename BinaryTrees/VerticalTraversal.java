package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        //We will map col -> row(contains minHeap of all values in that row)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        dfs(root, 0, 0 , map); //Populate the DS

        //Extract the values to the res accoding to the col values, as treemap is sorted with keys(col) we can access in order

        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();

            for(PriorityQueue<Integer> pq : rows.values()) {
                while(!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            res.add(colList);
        }

        return res;
    }

    public void dfs(TreeNode node, int row, int col, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;

        map.computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new PriorityQueue<>())
                .offer(node.val);

        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
}
