package Tree;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class BinaryTreeMaximumPathSum {
    private static int MAX_ANS;

    public static int maxPathSum(TreeNode root) {
        MAX_ANS = Integer.MIN_VALUE;
        helper(root);
        return MAX_ANS;
    }

    private static int helper(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;

        int left = helper(root.left);
        int right = helper(root.right);

        MAX_ANS = Math.max(MAX_ANS, root.val + Math.max(0, left) + Math.max(0, right));

        return root.val + Math.max(Math.max(left, right), 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}
