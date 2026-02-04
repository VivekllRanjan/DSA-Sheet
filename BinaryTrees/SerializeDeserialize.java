package BinaryTrees;

import BTrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {
    public String serialize(BTrees.TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<BTrees.TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BTrees.TreeNode node = q.poll();

            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public BTrees.TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] nodes = data.split(",");
        BTrees.TreeNode root = new BTrees.TreeNode(Integer.parseInt(nodes[0]));

        Queue<BTrees.TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty()) {
            BTrees.TreeNode curr = q.poll();

            if (!nodes[i].equals("null")) {
                curr.left = new BTrees.TreeNode(Integer.parseInt(nodes[i]));
                q.offer(curr.left);
            }
            i++;

            if (!nodes[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}
