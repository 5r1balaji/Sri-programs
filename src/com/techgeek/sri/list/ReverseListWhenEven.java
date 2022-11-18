package com.techgeek.sri.list;

import com.techgeek.sri.Node;
//TODO : to revisit

/**
 * Solution is to use recursive pass the head
 */
public class ReverseListWhenEven {
    public static void main(String[] args) {
        int[] arr_1 = {1,3,4, 2, 8,7, 12, 16};
        Node head = new Node(arr_1[0]);
        Node traverse = head;
        for (int i =1;i<arr_1.length;i++) {
            traverse.next= new Node(arr_1[i]);
            traverse = traverse.next;
        }
        traverse = head ;
        Node prev = traverse;
        while (traverse != null) {
            if (traverse.data % 2  == 0 ) {
              traverse = reverse(traverse, prev);
              prev = traverse;
            } else {
                prev = traverse;
                traverse = traverse.next;
            }
        }

        while(head != null) {
            System.out.print(head.data +" ");
            head = head.next;
        }
    }

    private static Node reverse(Node head, Node prev1) {
         Node traverse  = head;
         Node prev = null;
         Node curr = null;
        while (traverse != null && traverse.data % 2 == 0) {
            Node temp  = traverse.next;
            curr = traverse;
            curr.next = prev;
            prev = curr;
            traverse = temp;
        }
        prev1.next = prev;
        return traverse;
    }

}
