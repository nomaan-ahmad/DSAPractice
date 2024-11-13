package LinkedList;

public class RemoveNthNodeFromLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode ptr1 = head;
        ListNode ptr2 = head;
        for (int i = 1; i <= n; i++) ptr2 = ptr2.next;

        if (ptr2 == null) return head.next;

        while (ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1.next = ptr1.next.next;

        return head;
    }
}
