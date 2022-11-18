package com.techgeek.sri.sorts;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr1[] = {75, 7, 66, 11, 15};
        int arr2[] = {89, 1, 5, 19, 50, 100, 13};

        int arr3[] = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length + i] = arr2[i];
        }
        int l = 0;
        int r = arr3.length - 1;
        partition(arr3, l, r);
        Arrays.stream(arr3).forEach(System.out::println);
    }

    private static void partition(int[] arr, int l, int r) {
        if (l < r) {
            int mid  = (l + r) / 2;
            partition(arr, l, mid);
            partition(arr,mid + 1 , r);
            mergeSort(arr, mid, l, r);
        }
    }

    private static void mergeSort(int[] arr, int mid, int l, int r) {
        int[] left = new int[mid - l + 1];
        int[] right = new int[r - mid];

        for (int i = 0;i < left.length; i++) {
            left[i] = arr[l + i];
        }

        for (int i = 0;i < right.length; i++) {
            right[i] = arr[mid + 1 +i];
        }
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

}