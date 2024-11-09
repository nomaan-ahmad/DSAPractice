package LinkedList;

public class SinglyLinkedList {
    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    private Node head;
    public int count;
    public SinglyLinkedList() {
        count = 0;
    }
    public boolean add(int val) {
        Node node = new Node(val);

        if (head == null) head = node;
        else {
            Node temp = head;

            while(temp.next != null) temp = temp.next;

            temp.next = node;
        }

        this.count++;
        return true;
    }
    public boolean remove(){
        if (head == null) return false;
        else {
            Node temp = head;
            if (count == 1) head = null;
            while(temp.next.next != null) temp = temp.next;

            temp.next = null;
        }

        count--;
        return true;
    }
    public void traverse(){
        if (head == null) System.out.println("[]");
        else {
            Node temp = head;

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (temp != null) {
                sb.append(temp.val);
                if (temp.next != null) sb.append(",");
                temp = temp.next;
            }
            sb.append("]");

            System.out.println(sb.toString());
        }
    }
}
