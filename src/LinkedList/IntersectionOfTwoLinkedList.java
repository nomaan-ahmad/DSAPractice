package LinkedList;

// Problem statement: https://leetcode.com/problems/intersection-of-two-linked-lists/

/*
## Problem Statement:
    Given the heads of two singly linked lists, headA and headB, determine if there’s an intersection node.
    If there is, return the reference to this intersection node; if not, return None.

## Approaches:

    To solve this problem efficiently, we need to find the point at which the two lists start to share nodes.
    This can be tricky because the two lists may have different lengths.

    -> Approach 1: Using Lengths of the Lists

        - Calculate Lengths:
                * Traverse both lists individually to get their lengths: lenA and lenB.
        - Align the Starts:
                * Move the pointer of the longer list forward by the difference in lengths (|lenA - lenB|) to align the
                starting points for both lists.
        - Traverse Together:
                * Move both pointers one step at a time. The first time they point to the same node is the intersection node.
                * If they reach the end (None) without meeting, the lists do not intersect.

    -> Approach 2: Two-Pointer Technique

        This approach is a bit more elegant and does not require calculating the lengths of the lists explicitly.

        - Initialize Two Pointers:
                * Start two pointers, ptrA at the head of headA and ptrB at the head of headB.

        - Traverse the Lists with a Twist:
                * Move each pointer one step at a time.
                * When ptrA reaches the end of list A, reset it to the beginning of list B.
                * When ptrB reaches the end of list B, reset it to the beginning of list A.
                * This way, both pointers will travel the same number of steps and will eventually meet at the
                intersection point if it exists.

        - Meet or End:
                * If there’s an intersection, ptrA and ptrB will meet at the intersection node.
                * If they reach the end (None), they do not intersect.

        This works because each pointer traverses the length of both lists combined, ensuring they synchronize at the
        intersection node if there’s one.

## Complexity Analysis

    -> Time Complexity: O(m+n), where mm and nn are the lengths of the two lists.
        * Each pointer traverses each list exactly once.

    -> Space Complexity: O(1).
        * Only two pointers are used, making this a constant-space solution.
 */

/********************************************* Code **********************************************/
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        while (ptr1 != ptr2) {
            ptr1 = (ptr1 == null) ? headB : ptr1.next;
            ptr2 = (ptr2 == null) ? headA : ptr2.next;
        }

        return ptr1;
    }
}
