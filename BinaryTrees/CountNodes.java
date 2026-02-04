package BTrees;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lt = heightLeft(root);
        int rt = heightRight(root);

        if(lt == rt) return (1 << lt) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int heightLeft(TreeNode node) {
        int c = 0;
        while(node != null) {
            node = node.left;
            c++;
        }

        return c;
    }
    private int heightRight(TreeNode node) {
        int c = 0;
        while(node != null) {
            node = node.right;
            c++;
        }

        return c;
    }
}
