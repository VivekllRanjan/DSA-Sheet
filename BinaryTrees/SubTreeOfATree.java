package BinaryTrees;

import BTrees.TreeNode;

public class SubTreeOfATree {
    public boolean isSubtreeSerialize(BTrees.TreeNode root, BTrees.TreeNode subRoot) {
        String mainTree = serialize(root);
        String subTree = serialize(subRoot);
        return mainTree.contains(subTree);
    }

    private String serialize(BTrees.TreeNode root) {
        if (root == null) return "#"; // Null marker
        return "," + root.val + serialize(root.left) + serialize(root.right);
    }
    public boolean isSubtree(BTrees.TreeNode root, BTrees.TreeNode subRoot) {
        if(subRoot == null)
            return true;
        if(root == null)
            return false;

        if(sameTree(root,subRoot))
            return true;

        return isSubtree(root.left,subRoot) ||
                isSubtree(root.right,subRoot);

    }

    private boolean sameTree(BTrees.TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null || p.val != q.val) return false;

        return sameTree(p.left,q.left) && sameTree(p.right,q.right);
    }
}
