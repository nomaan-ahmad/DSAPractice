package LinkedList;

// https://leetcode.com/problems/merge-two-sorted-lists
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummyHead = new ListNode();
        ListNode itr = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                itr.next = list1;
                list1 = list1.next;
            } else {
                itr.next = list2;
                list2 = list2.next;
            }
            itr = itr.next;
        }

        if (list1 != null) {
            itr.next = list1;
        }

        if (list2 != null) {
            itr.next = list2;
        }

        //itr.next.next = null;
        return dummyHead.next;
    }
}
