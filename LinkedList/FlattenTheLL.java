package LinkedList;

// Problem statement: https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
public class FlattenTheLL {
    private static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }

    public static void main(String[] args) {
        Node head = makeList(new int[] {7,15,21,25,36,39,42,51,52,54,59,64,64,67,72,72,72,75,92,97});
        head.next = makeList(new int[] {16,17,30,46,49,55,59,63,65,76,78,80,86,86,90,94,98});
        head.next.next = makeList(new int[] {6,30,76,81,82,84,90,95});
        head.next.next.next = makeList(new int[] {77,90});
        head.next.next.next.next = makeList(new int[] {8,11,12,27,27,43,51,59,74,82,99});

        var flat = flatten(head);

    }
    private static Node makeList(int[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < arr.length; i++) {
            tail.bottom = new Node(arr[i]);
            tail = tail.bottom;
        }

        return head;
    }
    public static Node flatten(Node root) {
        if (root == null || root.next == null) return root;

        Node aux = root.next;
        root.next = null;

        while (aux != null) {
            root = merge(root, aux);

            Node temp = aux;
            aux = aux.next;
            temp.next = null;
        }

        return root;
    }

    private static Node merge(Node l1, Node l2) {
        Node head;

        if (l1.data <= l2.data) {
            head = l1;
            l1 = l1.bottom;
        } else {
            head = l2;
            l2 = l2.bottom;
        }

        Node tail = head;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.bottom = l1;
                l1 = l1.bottom;
            }else {
                tail.bottom = l2;
                l2 = l2.bottom;
            }

            tail = tail.bottom;
        }

        if (l1 != null) tail.bottom = l1;
        if (l2 != null) tail.bottom = l2;

        return head;
    }
}
