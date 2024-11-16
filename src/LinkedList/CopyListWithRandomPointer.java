package LinkedList;

public class CopyListWithRandomPointer {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(7);
        Node two = new Node(13);
        one.next = two;

        Node three = new Node(11);
        two.next = three;

        Node four = new Node(10);
        three.next = four;

        Node five = new Node(1);
        four.next = five;

        two.random = one;
        three.random = five;
        four.random = three;
        five.random = one;

        copyRandomList(one);

    }

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // making copy of the all the nodes just after each node
        Node aux = head;

        while (aux != null) {
            Node node = new Node(aux.val);
            Node next = aux.next;
            aux.next = node;
            node.next = next;

            aux = next;
        }

        // Setting random pointers for created copies
        aux = head;
        while (aux!= null) {
            aux.next.random = aux.random != null ? aux.random.next : null;
            aux = aux.next.next;
        }

        // separating old and new nodes

        Node dummyHead = new Node(-1);
        aux = dummyHead;
        Node next;

        while (head != null) {
            next = head.next.next;

            aux.next = head.next;
            head.next = next;
            aux = aux.next;

            head = next;
        }

        aux.next = null;
        return dummyHead.next;
    }
}
