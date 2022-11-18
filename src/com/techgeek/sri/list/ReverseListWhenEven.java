package com.techgeek.sri.list;


import java.util.List;

/**
 * Solution is to process elements of the list like graph i.e when traversing through the list,
 * If it encounters even, then process it separately in another method and viceversa for odd encounters
 * but update the traversingNode with the end of the reversed list
 *
 */
public class ReverseListWhenEven {
    public static void main(String[] args) {
        //int[] arr_1 = {4, 2, 8,1,3 ,7, 12, 16};
        int[] arr_1 = {1,3 ,7, 12, 16};
        //int[] arr_1 = {4,8,6, 12,1};
        ListNode head = new ListNode(arr_1[0]);
        ListNode traverse = head;
        for (int i =1;i<arr_1.length;i++) {
            traverse.next= new ListNode(arr_1[i]);
            traverse = traverse.next;
        }
        ListNode headNode = traverseNode(head, null, null);
        while (headNode != null) {
            System.out.println(headNode.data);
            headNode = headNode.next;
        }

    }

    private static ListNode traverseNode(ListNode traverse, ListNode head, ListNode currentNode) {

        while (traverse != null) {
            if (isOdd(traverse.data)) {
                if (head == null){
                    currentNode = new ListNode(traverse.data);
                    head = currentNode;
                }else {
                    currentNode.next = new ListNode(traverse.data);
                    currentNode = currentNode.next;
                }
            } else {
                return processEven(traverse, head, currentNode);
            }
            traverse = traverse.next;
        }
        return head;
    }

    private static ListNode processEven(ListNode traverse, ListNode head, ListNode currentNode) {
        ListNode even = null;
        ListNode evenHead = null;
        while (traverse != null && !isOdd(traverse.data)) {
                even  = reverseNode(traverse.data, even);
                if (evenHead == null){
                    evenHead = even;
                }
                traverse = traverse.next;
        }

        if (head == null) {
            head = even;
        } else {
            currentNode.next = even;
        }
        currentNode = evenHead;
        return traverseNode(traverse, head, currentNode);
    }

    private static ListNode reverseNode(int data, ListNode even) {
        ListNode newNode = new ListNode(data);
        newNode.next = even;
        return newNode;
    }

    private static boolean isOdd(int data) {
        return data % 2 != 0;
    }
}
