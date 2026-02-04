package BinaryTrees;

import BTrees.TreeNode;

public class LCA {
    public BTrees.TreeNode lowestCommonAncestor(BTrees.TreeNode root, BTrees.TreeNode p, BTrees.TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }

        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }

    public BTrees.TreeNode lowestCommonAncestor2(BTrees.TreeNode root, BTrees.TreeNode p, BTrees.TreeNode q) {
        if(root == null || root == p || root == q) return root;

        BTrees.TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;

        return (left != null) ? left : right;
    }
}
