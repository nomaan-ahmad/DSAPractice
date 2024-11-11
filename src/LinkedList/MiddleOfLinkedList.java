package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode first = head;
        ListNode second = head;

        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        return first;
    }
}
