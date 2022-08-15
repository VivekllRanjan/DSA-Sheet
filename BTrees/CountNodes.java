package BTrees;

public class CountNodes {


    public static class Tree extends BuildTree{
        public int countNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftNodes = countNodes(root.left);
            int rightNodes = countNodes(root.right);

            return leftNodes+rightNodes+1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BuildTree.BTree tree = new BuildTree.BTree();
        BuildTree.Node root = tree.buildTree(arr);

        Tree tr = new Tree();
        System.out.println(tr.countNodes(root));
    }

}
