package com.techgeek.sri.list;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(5);
        root.next = new ListNode(7);
        root.next.next = new ListNode(8);
        root.next.next.next = new ListNode(9);
        ListNode reverse = reverseList(root);
        while (reverse != null) {
            System.out.println(reverse.data);
            reverse = reverse.next;
        }
    }

    private static ListNode reverseList(ListNode root) {
        ListNode prev = null;
        ListNode curr;
        ListNode traverse = root;
        while (traverse != null) {
            curr = new ListNode(traverse.data);
            curr.next = prev;
            prev = curr;
            traverse = traverse.next;
        }
        return prev;
    }
}
