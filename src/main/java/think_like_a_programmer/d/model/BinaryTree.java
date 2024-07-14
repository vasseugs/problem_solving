package think_like_a_programmer.d.model;

import java.util.List;

public class BinaryTree {
    private List<TreeNode> nodes;
    private TreeNode root;

    public BinaryTree(List<TreeNode> nodes, TreeNode root) {
        this.nodes = nodes;
        this.root = root;
    }

    public int leavesCount() {
        return getLeavesCount(this.root);
    }

    private int getLeavesCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // базовый случай
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return 1;
        }
        int leftSubtreeLeavesCount = getLeavesCount(root.getLeftChild());
        int rightSubtreeLeavesCount = getLeavesCount(root.getRightChild());
        return leftSubtreeLeavesCount + rightSubtreeLeavesCount;
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
