package BinaryTrees;

public class MaxPathSum {
    private int max = Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode node) {
        if(node == null) return 0;

        int lhSum = Math.max(0,maxSum(node.left));

        int rhSum = Math.max(0,maxSum(node.right));

        max = Math.max(max, lhSum+rhSum+node.val);

        return node.val + Math.max(lhSum,rhSum);
    }
}
