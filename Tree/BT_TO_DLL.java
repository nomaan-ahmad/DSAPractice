package Tree;

// https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1
public class BT_TO_DLL {

    private static class Pair {
        Node head;
        Node tail;

        Pair(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    private static class Node {
        Node left, right;
        int data;

        Node(int d) {
            data = d;
            left = right = null;
        }

    }

    Node bToDLL(Node root) {
        return convert(root).head;
    }

    private Pair convert(Node root) {
        if (root == null) return new Pair(null,null);

        Pair first = convert(root.left);
        Pair second = convert(root.right);

        root.left = first.tail;
        root.right = second.head;
        if (first.tail != null) first.tail.right = root;
        if (second.head != null) second.head.left = root;

        return new Pair(first.head != null ? first.head : root, second.tail != null ? second.tail : root);
    }
}
