package Tree;

// https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfABinaryTree {
    private int MaxDia = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return MaxDia;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        MaxDia = Math.max(MaxDia, 1 + left + right);

        return 1 + Math.max(left, right);
    }
}
