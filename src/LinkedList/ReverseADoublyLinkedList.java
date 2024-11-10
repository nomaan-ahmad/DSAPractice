package LinkedList;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class ReverseADoublyLinkedList {
    public DLLNode reverseDLL(DLLNode head) {
        if (head == null || head.next == null) return head;

        DLLNode prev = null;
        DLLNode curr = head;
        DLLNode next = head.next;

        while (curr != null) {
            next = curr.next;

            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Reversing a Doubly Linked List using recursion
    public DLLNode reverseRecurse(DLLNode node) {
        if (node == null) return null;

        DLLNode next = node.next;

        node.next = node.prev;
        node.prev = next;

        if (node.prev == null) return node;

        return reverseRecurse(node.prev);
    }
}
