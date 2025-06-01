package Tree;

// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
public class EvenValuedGrandparent {
    public static int sumEvenGrandparent(TreeNode root) {
        int count = 0;

        if (root.left != null) {
            count += helper(root, root.left, root.left.left);
            count += helper(root, root.left, root.left.right);
        }
        if (root.right != null) {
            count += helper(root, root.right, root.right.left);
            count += helper(root, root.right, root.right.right);
        }

        return count;
    }

    private static int helper(TreeNode dadu, TreeNode papa, TreeNode me) {
        if (me == null) return 0;

        int count = 0;
        if ((dadu.val & 1) == 0) count += me.val;

        count += helper(papa, me, me.left);
        count += helper(papa, me, me.right);

        return count;
    }

    public static void main(String[] args) {
        // 0
        TreeNode node = new TreeNode(6);

        // 1
        node.left = new TreeNode(7);
        node.right = new TreeNode(8);

        // 2
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(7);

        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(3);

        // 3
        node.left.left.left = new TreeNode(9);

        node.left.right.left = new TreeNode(1);
        node.left.right.right = new TreeNode(4);

        node.right.right.right = new TreeNode(5);

        System.out.println(sumEvenGrandparent(node));
    }
}
