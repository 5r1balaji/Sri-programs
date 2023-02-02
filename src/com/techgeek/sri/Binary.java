package com.techgeek.sri;

public class Binary {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int element = 6;
        System.out.println(recursive(arr, element, 0, arr.length - 1));
    }
    // 0, 5
    // 4
    private static int recursive(int[] arr, int element, int start , int end) {
        int mid = (start + end) / 2;
        if (start < 0 || end < 0) {
            return -1;
        }
        if (start == end && element != arr[mid]) {
            return -1;
        }
        if (element == arr[mid]) {
            return mid;
        }

        if (arr[mid] > element) {
            return recursive(arr, element, start, mid - 1);
        } else {
            return recursive(arr, element, mid + 1, end);// 3, 5
        }
    }

}
