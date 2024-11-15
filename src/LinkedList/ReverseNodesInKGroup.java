package LinkedList;
import java.util.Scanner;

// Problem statement: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) return head;

        String method = new Scanner(System.in).nextLine().toLowerCase();

        // select way of operating over this list: Iterative or Recursively
        if (method.equals(("iterative"))) return reverseKGroupIteratively(head, k);
        else return reverseKGroupRecursively(head, k);
    }

    /**************************************** Iterative solution ****************************************/
    public ListNode reverseKGroupIteratively(ListNode head, int k) {
        ListNode auxEnd = head;

        for (int i = 1; i < k; i++) auxEnd = auxEnd.next;

        ListNode dummyHead = new ListNode(-1);
        ListNode result = dummyHead;
        dummyHead.next = head;

        while (auxEnd != null) {
            ListNode curr = dummyHead.next;
            ListNode next;

            ListNode prev = dummyHead;

            while (prev != auxEnd) {
                next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            auxEnd = dummyHead.next;
            dummyHead.next = prev;
            auxEnd.next = curr;
            dummyHead = auxEnd;

            int count = k;
            while (count-- > 0 && auxEnd != null) auxEnd = auxEnd.next;
        }

        return result.next;
    }

    /**************************************** Recursive solution ****************************************/
    public static ListNode reverseKGroupRecursively(ListNode head, int k){
        int countNodes = 0;
        ListNode curr = head;
        while (curr!=null){
            countNodes++;
            if (countNodes == k) break;
            curr = curr.next;
        }

        if (countNodes < k) return head;

        assert curr != null;
        ListNode post = reverseKGroupRecursively(curr.next, k);

        curr = head;
        ListNode prev = null;
        ListNode next;

        int count = 0;
        while (curr!=null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        head.next = post;
        return prev;
    }
}
