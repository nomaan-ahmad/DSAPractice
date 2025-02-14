package LinkedList;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        var result = deleteDuplicates(head);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr;

            while (temp != null) {
                if (temp.val != curr.val) break;
                else temp = temp.next;
            }

            if (temp == curr.next) prev = curr;
            else {
                if (prev == null) {
                    if (temp == null) return null;
                    else {

                        head = temp;
                    }
                } else {
                    prev.next = temp;
                }
            }

            curr = temp;
        }

        return head;
    }
}
