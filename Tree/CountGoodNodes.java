package Tree;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        return helper(root, max);
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) return 0;

        int count = 0;
        if (root.val >= max[0]) {
            max[0] = root.val;
            count += 1;
        }
        int maxTemp = max[0];

        count += helper(root.left, max);
        max[0] = maxTemp;

        count += helper(root.right, max);
        max[0] = maxTemp;

        return count;
    }
}
