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
    public void add(int val) {
        Node node = new Node(val);

        if (head == null) head = node;
        else {
            Node temp = head;

            while(temp.next != null) temp = temp.next;

            temp.next = node;
        }

        traverse();
        this.count++;
    }

    public void addAll(int[] arr)
    {
        if (arr.length == 0) return;

        // Made a list containing all the array elements
        Node tempHead = new Node(arr[0]);
        Node tempTail = tempHead;
        for (int i = 1; i < arr.length; i++){
            tempTail.next = new Node(arr[i]);
            tempTail = tempTail.next;
        }

        if (head == null) head = tempHead;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;

            temp.next = tempHead;
        }

        this.count += arr.length;
        traverse();
    }

    public void remove(int index) {
        if (index < 0 || this.count <= index) throw new IndexOutOfBoundsException();

        if (index == 0) {
            if (count == 1) head = null;
            else head = head.next;
        }else if (index == count-1) {
            int counter = 0;
            Node temp = head;

            while (++counter < index) temp = temp.next;
            temp.next = null;
        }else {
            int counter = 0;
            Node temp = head;

            while (++counter < index) temp = temp.next;

            temp.next = temp.next.next;
        }

        traverse();
        this.count--;
    }
    public void remove(){
        if (head == null) return;
        else {
            Node temp = head;
            if (this.count == 1) head = null;
            else{
                while(temp.next.next != null) temp = temp.next;

                temp.next = null;
            }
        }

        traverse();
        this.count--;
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
