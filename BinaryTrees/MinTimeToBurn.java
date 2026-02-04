package BinaryTrees;

import BTrees.TreeNode;

import java.util.*;

public class MinTimeToBurn {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        public int amountOfTime(BTrees.TreeNode root, int start) {
            Map<BTrees.TreeNode, BTrees.TreeNode> parent = new HashMap<>();
            Queue<BTrees.TreeNode> q = new LinkedList<>();

            q.offer(root);
            BTrees.TreeNode target = null;

            while(!q.isEmpty()) {
                BTrees.TreeNode curr = q.poll();

                if(curr.val == start) target = curr;

                if(curr.left != null) {
                    parent.put(curr.left, curr);
                    q.offer(curr.left);
                }

                if(curr.right != null) {
                    parent.put(curr.right, curr);
                    q.offer(curr.right);
                }
            }


            Set<BTrees.TreeNode> visited = new HashSet<>();
            q.offer(target);
            visited.add(target);

            int time = 0;

            while(!q.isEmpty()) {
                int size = q.size();
                boolean burned = false;

                for(int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();

                    if(curr.left != null && !visited.contains(curr.left)) {
                        visited.add(curr.left);
                        q.offer(curr.left);
                        burned = true;
                    }

                    if(curr.right != null && !visited.contains(curr.right)) {
                        visited.add(curr.right);
                        q.offer(curr.right);
                        burned = true;
                    }

                    if(parent.get(curr) != null && !visited.contains(parent.get(curr))) {
                        visited.add(parent.get(curr));
                        q.offer(parent.get(curr));
                        burned = true;
                    }
                }
                if(burned) time++;
            }

            return time;
        }
    }
}
