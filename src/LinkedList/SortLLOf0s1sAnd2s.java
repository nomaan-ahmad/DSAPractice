package LinkedList;

// Problem Statement : https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
public class SortLLOf0s1sAnd2s {
    static Node segregate(Node head) {
        Node zeroHead = null, zero = null;
        Node oneHead = null, one = null;
        Node twoHead = null, two = null;


        while (head != null) {
            Node temp = head;
            head = head.next;
            temp.next = null;

            switch (temp.data) {
                case 0 -> {
                    if (zeroHead == null) {
                        zero = temp;
                        zeroHead = temp;
                    } else {
                        zero.next = temp;
                        zero = zero.next;
                    }
                }
                case 1 -> {
                    if (oneHead == null) {
                        one = temp;
                        oneHead = temp;
                    } else {
                        one.next = temp;
                        one = one.next;
                    }
                }
                case 2 -> {
                    if (twoHead == null) {
                        two = temp;
                        twoHead = temp;
                    } else {
                        two.next = temp;
                        two = two.next;
                    }
                }
            }
        }

        if (zeroHead != null) {
            if (oneHead != null) {
                zeroHead.next = oneHead;
                oneHead.next = twoHead;


                return zeroHead;
            }else return zeroHead.next = twoHead;
        } else {
            if (oneHead != null) {
                oneHead.next = twoHead;
                return oneHead;
            } else return twoHead;
        }
    }
}
