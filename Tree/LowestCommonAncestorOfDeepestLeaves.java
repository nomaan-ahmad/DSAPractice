package Tree;

// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
public class LowestCommonAncestorOfDeepestLeaves {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Pair {
        int level;
        TreeNode node;

        Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        var result = dfs(root, 0);

        return result.node;
    }

    private static Pair dfs(TreeNode node, int level) {
        if (node == null) return null;

        if (node.left == null && node.right == null) return new Pair(level, node);

        var left = dfs(node.left, level + 1);
        var right = dfs(node.right, level + 1);

        if (left == null) return right;
        if (right == null) return left;

        if (left.level == right.level) return new Pair(left.level, node);
        if (right.level > left.level) return right;
        else return left;
    }

    public static void main(String[] args) {

    }
}
