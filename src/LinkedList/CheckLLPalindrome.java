package LinkedList;

public class CheckLLPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode curr = head;
        ListNode fast = head;
        ListNode next, prev = null;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;

            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        if (fast != null) curr = curr.next;

        while (prev != null) {
            if (prev.val != curr.val) return false;

            prev = prev.next;
            curr = curr.next;
        }

        return true;
    }
}
