package LinkedList;

import java.util.List;

// problem statement: https://leetcode.com/problems/rotate-list/description/
public class RotateTheList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = length(head);
        k = k % len;
        if (k == 0) return head;

        ListNode fast = head;
        for (int i = 1; i <= k; i++) fast = fast.next;

        ListNode slow = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    private int length(ListNode head) {
        if (head == null) return 0;

        int count = 0;

        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }
}
