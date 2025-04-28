package BinaryTrees;

import javax.swing.*;
import java.awt.*;
import BinaryTrees.TreeNode;

public class TreeVisualizer extends JPanel {
    private final TreeNode root;
    private final int nodeSize = 30;
    private final int verticalSpacing = 60;

    public TreeVisualizer(TreeNode root) {
        this.root = root;
        setPreferredSize(new Dimension(1200, 800));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, root, getWidth() / 2, 40, getWidth() / 4);
    }

    private void drawTree(Graphics g, TreeNode node, int x, int y, int xOffset) {
        if (node == null) return;

        g.setColor(Color.BLACK);
        g.fillOval(x - nodeSize / 2, y - nodeSize / 2, nodeSize, nodeSize);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(node.val), x - 6, y + 4);

        if (node.left != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x - xOffset, y + verticalSpacing);
            drawTree(g, node.left, x - xOffset, y + verticalSpacing, xOffset / 2);
        }

        if (node.right != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x + xOffset, y + verticalSpacing);
            drawTree(g, node.right, x + xOffset, y + verticalSpacing, xOffset / 2);
        }
    }

    public static void show(TreeNode root) {
        JFrame frame = new JFrame("Binary Tree Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TreeVisualizer(root));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

