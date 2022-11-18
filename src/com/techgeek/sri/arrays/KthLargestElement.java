package com.techgeek.sri.arrays;

import java.util.*;

public class KthLargestElement {
    public static void main(String[] args) {
        int arr[] = {7,4,6,3,9,1};
        int k = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0;i < arr.length;i++){
             if (i <= k-1) {
                 pq.add(arr[i]);
             } else if(i > k-1 && pq.peek() < arr[i]) {
                  pq.poll();
                  pq.add(arr[i]);
             }
        }
        System.out.println(pq.peek());
    }

}
