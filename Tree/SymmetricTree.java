package Tree;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return check(root.left, root.right);
    }

    private static boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) return (left == null && right == null);

        return (left.val == right.val)
                && check(left.left, right.right)
                && check(left.right, right.left);
    }
}
