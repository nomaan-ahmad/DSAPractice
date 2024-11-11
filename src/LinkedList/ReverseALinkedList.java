package LinkedList;

public class ReverseALinkedList {
    /* ******************* Iterative solution ************************** */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while (curr != null) {
            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    /* ******************* Using two pointers in recursion ************************** */
    public ListNode reverseRecurseI(ListNode head) {
        if (head == null) return null;

        return recurse(head, null);
    }
    private ListNode recurse(ListNode curr, ListNode prev) {
        if (curr.next == null) {
            curr.next = prev;
            return curr;
        }

        ListNode next = curr.next;
        ListNode aux = recurse(next, curr);

        curr.next = prev;
        return aux;
    }

    /* ******************* Most efficient solution using recursion ************************** */
    public ListNode reverseRecurseII(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }
}
