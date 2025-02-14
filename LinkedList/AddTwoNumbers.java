package LinkedList;

// Problem statement: https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carry = sum/10;
        int remainder = sum % 10;

        l1 = l1.next;
        l2 = l2.next;

        ListNode head = new ListNode(remainder);
        ListNode tail = head;

        while (l1 != null || l2 != null) {

            sum = 0;

            if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;

            carry = sum/10;
            remainder = sum % 10;

            tail.next = new ListNode(remainder);
            tail = tail.next;
        }

        if (carry != 0) tail.next = new ListNode(carry);
        return head;
    }
}
