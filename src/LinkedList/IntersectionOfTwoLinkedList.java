package LinkedList;

import java.util.HashSet;

public class IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        while (ptr1 != ptr2) {
            ptr1 = (ptr1 == null) ? headB : ptr1.next;
            ptr2 = (ptr2 == null) ? headA : ptr2.next;
        }

        return ptr1;
    }
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> box = new HashSet<>();

        ListNode ungli1 = headA;

        while (ungli1 != null)
        {
            box.add(ungli1);
            ungli1 = ungli1.next;
        }


    }*/
}
