package Tree;

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {this.val = val;}
}
public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(9);

        System.out.println(largestValues(node));
    }
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        helper(nodes, result);
        return result;
    }

    private static void helper(Queue<TreeNode> nodes, List<Integer> result) {
        if (nodes.isEmpty()) return;

        int largest = Integer.MIN_VALUE;
        int len = nodes.size();

        while (len-- > 0) {
            TreeNode node = nodes.poll();
            assert node != null;
            largest = Math.max(largest, node.val);

            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
        }

        result.add(largest);
        helper(nodes, result);
    }
}
