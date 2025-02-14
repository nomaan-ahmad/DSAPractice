package LinkedList;

// Problem statement: https://leetcode.com/problems/delete-node-in-a-linked-list/description/
public class DeleteNodeInLinkedListWithATwist {
    public void deleteNode(ListNode node) {

        ListNode ptr1 = node;
        ListNode ptr2 = ptr1.next;

        while (ptr2.next != null) {
            ptr1.val = ptr2.val;

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1.val = ptr2.val;
        ptr1.next = null;
    }
}
