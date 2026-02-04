package BinaryTrees;

import BTrees.TreeNode;

import java.util.*;

public class NodesAtDistanceK {
    private List<Integer> nodes = new ArrayList<>();
    private Map<BTrees.TreeNode, BTrees.TreeNode> parent = new HashMap<>();
    private Set<BTrees.TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(BTrees.TreeNode root, BTrees.TreeNode target, int k) {

        if(root == null) return nodes;

        Queue<BTrees.TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            BTrees.TreeNode curr = q.poll();

            if(curr.left != null) {
                q.offer(curr.left);
                parent.put(curr.left, curr);
            }
            if(curr.right != null) {
                q.offer(curr.right);
                parent.put(curr.right, curr);
            }

        }

        dfs(target, k);

        return nodes;
    }

    private void dfs(TreeNode node, int distance) {

        if(node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);

        if(distance == 0){
            nodes.add(node.val);
            return;
        }

        //Left
        dfs(node.left, distance - 1);
        //Right
        dfs(node.right, distance - 1);
        //Up
        dfs(parent.getOrDefault(node, null), distance - 1);

    }
}
