package dataStructures;

import java.util.Objects;

public class Node<E> {

    public E data;
    public Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public Node(E data) {
        this(data, null);
    }

    public Node(E[] dataSeq) {
        if (dataSeq == null || dataSeq.length == 0) return;

        Node<E> connected = null;
        for (int i = dataSeq.length-1; i > 0; i--) {
            connected = new Node(dataSeq[i], connected);
        }
        this.data = dataSeq[0];
        this.next = connected;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) return false;

        Node<E> node = (Node<E>) obj;
        boolean dataEquals = this.data.equals(node.data);
        boolean ptrEquals = Objects.equals(this.next, node.next);
        return dataEquals && ptrEquals;
    }

    @Override
    public String toString() {
        Node<E> ptr = this;
        StringBuilder sb = new StringBuilder("[");
        while (ptr != null) {
            sb.append(ptr.data).append(" -> ");
            ptr = ptr.next;
        }
        return sb.append("]").toString();
    }

    /* debugging purposes
    public static void main(String[] args) {

        Integer[] nums = {};
        Node<Integer> head = new Node<Integer>(nums);
        System.out.println(head);

    }
    */

}
