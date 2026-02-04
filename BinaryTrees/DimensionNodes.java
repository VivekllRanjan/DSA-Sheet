package BinaryTrees;

public class DimensionNodes {


    public static class Tree extends BuildTree{

        public class TreeInfo{
            int ht;
            int diam;
            TreeInfo(int ht, int diam){
                this.ht = ht;
                this.diam = diam;
            }
        }
        public int countNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftNodes = countNodes(root.left);
            int rightNodes = countNodes(root.right);

            return leftNodes+rightNodes+1;
        }

        public int height(Node root){
            if(root == null)
                return 0;

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int myHeight = Math.max(leftHeight,rightHeight)+1;

            return myHeight;
        }

        public int diameter(Node root){

            if(root == null) return 0;

            int LD = diameter(root.left);
            int RD = diameter(root.right);
            int D3 = height(root.left)+height(root.right)+1;

            return Math.max(LD,Math.max(RD,D3));
        }

        public TreeInfo diameter2(Node root){
            if(root == null) {
                return new TreeInfo(0,0);
            }

            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);

            int myHeight = Math.max(left.ht, right.ht)+1;

            int LD = left.diam;
            int RD = right.diam;
            int D3 = left.ht + right.ht + 1;

            int myDiam = Math.max(Math.max(LD,RD),D3);

            TreeInfo myTree = new TreeInfo(myHeight,myDiam);

            return myTree;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BuildTree.BTree tree = new BuildTree.BTree();
        BuildTree.Node root = tree.buildTree(arr);

        Tree tr = new Tree();
        System.out.println(tr.countNodes(root));

        System.out.println(tr.height(root));

        System.out.println(tr.diameter(root));

        System.out.println(tr.diameter2(root).diam);
    }

}
