package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Program to print the immediate next greater element on the left  and right.
 *
 * 8,-1,-90,100,5,2,10,6,4
 * right : 100,100,100,-1,10,10,-1,-1,-1
 * left : -1,8,-1,-1,100,5,100,10,6
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int arr [] ={ 8,-1,-90,100,5,2,10,6,4};
        printNextGreater(arr);
    }

    private static void printNextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int [arr.length];
        for (int i = 0; i < arr.length; i++) {
            left[i] = -1;
            right[i] = -1;
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                right[stack.pop()] = arr[i];
            }
            if (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                left[i] = arr[stack.peek()];
            }
            stack.add(i);
        }
        Arrays.stream(left).forEach(k -> System.out.print(k+","));
        System.out.println("\n");
        Arrays.stream(right).forEach(k -> System.out.print(k+","));
    }


}
