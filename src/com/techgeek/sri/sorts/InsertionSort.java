package com.techgeek.sri.sorts;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        int key ;
        int j;
        for (int i = 1;i<arr.length;i++) {
            j = i-1;
            key = arr[i];
            while(j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
