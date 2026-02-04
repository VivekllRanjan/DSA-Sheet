package BinaryTrees;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode buildTree(int val, int currentDepth, int maxDepth) {
        if (currentDepth > maxDepth) return null;

        TreeNode node = new TreeNode(val);
        node.left = buildTree(2 * val, currentDepth + 1, maxDepth);
        node.right = buildTree(2 * val + 1, currentDepth + 1, maxDepth);

        return node;
    }

    public TreeNode buildBalancedTree(int val, int maxDepth) {
        return buildTree(val, 1, maxDepth);
    }


}