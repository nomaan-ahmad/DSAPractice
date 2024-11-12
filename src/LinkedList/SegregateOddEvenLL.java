package LinkedList;
public class SegregateOddEvenLL {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        ListNode itr = head.next.next;

        while (itr != null) {
            odd.next = itr;
            odd = odd.next;
            itr = itr.next;

            if (itr != null) {
                even.next = itr;
                even = even.next;
                itr = itr.next;
            }
        }

        odd.next = evenHead;
        even.next = null;

        return head;
    }
}
