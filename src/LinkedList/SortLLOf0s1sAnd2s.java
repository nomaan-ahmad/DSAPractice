package LinkedList;

// Problem Statement : https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
public class SortLLOf0s1sAnd2s {
    static Node segregate(Node head) {
        Node zeroHead = null, zeroTail = null;
        Node oneHead = null, oneTail = null;
        Node twoHead = null, twoTail = null;

        while (head != null) {
            switch (head.data) {
                case 0 -> {
                    if (zeroHead == null) {
                        zeroHead = head;
                        zeroTail = head;
                    } else {
                        zeroTail.next = head;
                        zeroTail = zeroTail.next;
                    }
                }
                case 1 -> {
                    if (oneHead == null) {
                        oneHead = head;
                        oneTail = head;
                    } else {
                        oneTail.next = head;
                        oneTail = oneTail.next;
                    }
                }
                case 2 -> {
                    if (twoHead == null) {
                        twoHead = head;
                        twoTail = head;
                    } else {
                        twoTail.next = head;
                        twoTail = twoTail.next;
                    }
                }
            }

            head = head.next;
        }

        Node temp = new Node(-1);
        head = temp;

        if (zeroHead != null) {
            temp.next = zeroHead;
            temp = zeroTail;
        }

        if (oneHead != null) {
            temp.next = oneHead;
            temp = oneTail;
        }

        if (twoHead != null) {
            temp.next = twoHead;
            temp = twoTail;
        }

        temp.next = null;

        return head.next;
    }
}
