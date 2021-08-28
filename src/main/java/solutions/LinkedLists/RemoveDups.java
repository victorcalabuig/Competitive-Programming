package solutions.LinkedLists;

import dataStructures.Node;

import java.util.HashSet;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
class RemoveDups {

    static <E> void removeDupsV1(Node<E> head) {
        if (head == null) return;

        HashSet<E> elems = new HashSet<>();
        elems.add(head.data);
        Node<E> slow = head, fast = head.next;

        while (fast != null) {
            if (elems.add(fast.data)) {
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }

        slow.next = null;

    }

    // todo reuse head pointer, no null check needed nor final step
    static <E> void removeDupsV2(Node<E> head) {

    }

    /* Debugging
    public static void main(String[] args) {
        Integer[] nums = {1,1,1};
        Node<Integer> head = new Node<Integer>(nums);

        System.out.println("Before: " + head);
        removeDupsV1(head);
        System.out.println("After : " + head);
    }
    */

}