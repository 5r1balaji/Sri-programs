package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayRotation {
    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5,6,7};
        int i =0,r = 3,n = arr.length;
        if (r >= n) {
            r = r % n;
        }
        Queue<Integer> queue = new LinkedList<>();
        while(i < n && r > 0) {
            if (i<r) {
                queue.add(arr[i]);
            }
            if (i+r < n) {
                arr[i] = arr[i+r];
            }
            // n is 1 more than the indexes i.e 7 so n-i will tell if the current i is at the index to rotate
            // r indicates the MAxindex , after which the rotation should be started
            // n-i <=r tells if there is a room for rotation
            if (n-i <= r && !queue.isEmpty()) {
                arr[i] = queue.poll();
            }
            i++;
        }

        Arrays.stream(arr).forEach(System.out::print);
    }
}
