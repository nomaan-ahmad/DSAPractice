package Tree;

// https://leetcode.com/problems/binary-tree-pruning/description/
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return helper(root) ? null : root;
    }

    private boolean helper(TreeNode root) {
        if (root == null) return true;

        boolean left = helper(root.left);
        if (left) root.left = null;

        boolean right = helper(root.right);
        if (right) root.right = null;

        return root.val == 0 && left && right;
    }
}
