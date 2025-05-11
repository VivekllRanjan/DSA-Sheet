package BinaryTrees;

public class Diameter {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfsTree(root);
        return max;
    }

    private int dfsTree(TreeNode node) {
        if(node == null) return 0;

        int lh = dfsTree(node.left);
        int rh = dfsTree(node.right);
        max = Math.max(lh+rh, max);
        return 1 + Math.max(lh,rh);
    }
}
