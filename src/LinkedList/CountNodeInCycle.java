package LinkedList;

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
public class CountNodeInCycle {
    public int countNodesinLoop(Node head) {

        if (head == null) return 0;

        Node point = DetectCycle(head);

        if (point == null) return 0;

        Node slow = point;

        int counter = 0;
        while(slow.next != point) {
            slow = slow.next;
            counter++;
        }

        return counter+1;

    }

    private Node DetectCycle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return slow;
        }

        return null;
    }
}
