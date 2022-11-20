package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArrayRotation {
    public static void main(String[] args) {
        int arr[] ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int rotations = 10,arrayLength = arr.length;
        if (rotations >= arrayLength) {
            rotations = rotations % arrayLength ; //i.e if arrayLength = 5, rotations = 10,then 10/5
        }
        Arrays.stream(rotateArray(rotations, arrayLength, arr)).forEach(k -> System.out.print(k +","));
    }

    /**
     * Rotations are considered as displacements which will be added to the shiftIndex positions.
     * 1. For n rotations n elements from the back of the array will be moved to the front.
     *    i.e {1,2,3,4,5} when r = 2 . The last 2 elements will be moved to front i.e 4,5
     * 2. The rest of the elements i.e n - r = {1,2,3} will be shifting to their new positions i.e (i + r)
     *    ex  0, 1, 2 positions will be moved to 3,4,5
     * 3. {4, 5} copied in the first step will be populated in the array index positions for 0 to r - 1 i.e {0,1}
     * @param rotations
     * @param arrayLength
     * @param arr
     * @return
     */
    private static int[] rotateArray(int rotations, int arrayLength, int[] arr) {
        int i, shiftIndex = arrayLength - rotations - 1 ;
        Stack<Integer> queue = new Stack<>();
        // Elements to shift from back to front
        for (i = arrayLength - 1; i > arrayLength - rotations -1; i --) {
            queue.add(arr[i]);
        }
        // Elements to shift from front to their rotated displacements
        while (shiftIndex >= 0 ) {
            arr[shiftIndex + rotations] = arr[shiftIndex];
            shiftIndex--;
        }
        i  = 0;
        // Backfill the copied rotated elements from the back
        while (i < rotations && !queue.isEmpty() ) {
            arr[i++] = queue.pop();
        }
        return arr;
    }
}
