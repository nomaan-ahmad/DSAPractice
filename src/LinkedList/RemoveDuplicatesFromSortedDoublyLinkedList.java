package LinkedList;

// Problem statement: https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1
public class RemoveDuplicatesFromSortedDoublyLinkedList {
    public DLLNode removeDuplicates(DLLNode head){
        if (head == null || head.next == null) return head;
        DLLNode tail = head;

        DLLNode itr = head.next;

        while (itr != null)
        {
            if (tail.data != itr.data) {
                itr.prev = tail;
                tail.next = itr;
                tail = tail.next;
            }

            itr = itr.next;
        }

        tail.next = null;
        return head;
    }
}
