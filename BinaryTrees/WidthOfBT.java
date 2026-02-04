package BinaryTrees;

import BTrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBT {
    class Pair {
        BTrees.TreeNode node;
        int index;
        Pair(BTrees.TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(BTrees.TreeNode root) {
        int maxWidth = 0;
        if(root == null) return maxWidth;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {
            int firstIndex = 0;
            int lastIndex = 0;
            int size = q.size();
            int indexOffset = q.peek().index;
            for(int i = 0; i < size; i++) {
                Pair current = q.poll();
                TreeNode node = current.node;
                int idx = current.index - indexOffset;

                if(i == 0) firstIndex = idx;
                if(i == size - 1) lastIndex = idx;

                if(node.left != null) q.offer(new Pair(node.left, 2 * idx));
                if(node.right != null) q.offer(new Pair(node.right, 2 * idx + 1));
            }
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }
}
