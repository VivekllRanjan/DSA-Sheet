package BTrees;

import BinaryTrees.TreeNode;

public class InvertTree {
    public TreeNode invertTree(TreeNode node) {
        if(node == null) return null;

        TreeNode temp = new TreeNode();
        temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertTree(node.left);
        invertTree(node.right);

        return node;
    }
}
