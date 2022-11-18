package com.techgeek.sri.list;

import com.techgeek.sri.Node;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.next = new Node(7);
        root.next.next = new Node(8);
        root.next.next.next = new Node(9);
        Node reverse = reverseList(root);
        while (reverse != null) {
            System.out.println(reverse.data);
            reverse = reverse.next;
        }
    }

    private static Node reverseList(Node root) {
        Node traverse = root;
        Node prev = null;
        Node next = null;
        while (traverse != null) {
            Node temp = traverse.next;
            prev = new Node(traverse.data);
            prev.next = next;
            next = prev;
            traverse = temp;
        }
        return prev;
    }
}
