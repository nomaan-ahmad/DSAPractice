package LinkedList.Sorting;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeSort {
    public ListNode Sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = MiddleNode(head);
        ListNode start2 = mid.next;
        mid.next = null;

        ListNode left = Sort(head);
        ListNode right = Sort(start2);

        return Merge(left, right);
    }

    private ListNode MiddleNode(ListNode head) {
        if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    private ListNode Merge(ListNode l1, ListNode l2) {
        ListNode head;

        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }

        ListNode itr = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                itr.next = l1;
                l1 = l1.next;
            } else {
                itr.next = l2;
                l2 = l2.next;
            }

            itr = itr.next;
        }

        if (l1 != null) itr.next = l1;
        if (l2 != null) itr.next = l2;

        return head;
    }
}
