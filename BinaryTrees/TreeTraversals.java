package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversals {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        preOrder(ans, root);
        return ans;
    }
    private static void preOrder(List<Integer> ans, TreeNode node) {
        if(node == null) return;

        ans.add(node.val);
        preOrder(ans, node.left);
        preOrder(ans, node.right);
    }



    public static void main(String[] args) {
        int depth = 3;
        TreeNode root = new TreeNode();
        root = root.buildBalancedTree(1, depth);
        TreeVisualizer.show(root);
        //printTree(root);
        System.out.println(preorderTraversal(root));
    }

    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int level) {
        if (node == null) return;

        printTree(node.right, level + 1);
        System.out.println("    ".repeat(level) + node.val);
        printTree(node.left, level + 1);
    }
}
