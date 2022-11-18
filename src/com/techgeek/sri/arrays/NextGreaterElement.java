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

        int left [] = new int[arr.length];
        int right[] = new int[arr.length];
        int largest = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < arr.length;i++) {
            right[i] = -1;
            left[i] = -1;
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                right[stack.pop()] = arr[i];
            }
            if (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                left[i] = arr[stack.peek()];
                largest = arr[stack.peek()];
            }
            if (arr[i] < largest) {
                left[i] = largest;
            }
            stack.add(i);

        }
        System.out.println(" jhi mymnsmr");

        System.out.println("Right :");
        Arrays.stream(right).forEach(i -> System.out.print(i + " "));
        System.out.println("\nLeft");
        Arrays.stream(left).forEach(i -> System.out.print(i + " "));
    }

    private static void printNextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int [arr.length];
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length;i++) {
            left[i] = -1;
            right[i] = -1;
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                right[stack.pop()] = arr[i];
            }
            if (arr[i] < largest) {
                left[i] = largest;
            }
            if (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                left[i] = arr[stack.peek()];
                largest = Math.max(largest,left[i]);
            }

            stack.add(i);
        }

        Arrays.stream(left).forEach(k -> System.out.print(k+","));
        System.out.println("\n");
        Arrays.stream(right).forEach(k -> System.out.print(k+","));
    }


}
