package LinkedList;

public class AddOneToListNumber {
    public Node addOne(Node head) {
        int carry = helper(head);
        if (carry == 1) {
            Node temp = new Node(1);
            temp.next = head;
            return temp;
        }

        return head;
    }

    private int helper(Node head) {
        if (head.next == null) {
            if (head.data == 9) {
                head.data = 0;
                return 1;
            }else {
                head.data += 1;
                return 0;
            }
        }

        int carry = helper(head.next);
        if (carry == 0) return 0;
        else {
            if (head.data == 9) {
                head.data = 0;
                return 1;
            }else {
                head.data += 1;
                return 0;
            }
        }
    }
}
