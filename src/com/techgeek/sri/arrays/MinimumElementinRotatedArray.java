package com.techgeek.sri.arrays;

/**
 * Find the smallest element index in a sorted and rotated array
 * The idea is to find the index of the element that has the adjacent element left or right not in increasing order.
 * i.e {5,6,7,8,1,2,3,4}
 * index of element 8 and element 1
 * 1. Find the mid index and check if the adjacent elements (i.e mid + 1 or mid - 1) are not in order.
 * 2. else check if range mid to high has a disorder. if yes then move the range of mid by 1 ie. mid + 1 .
 * 3. If the range is in order it means none of the indices are disorder so move the range from low to mid - 1.
 * 4. mid -1 because the check is already made with the previous index mentioned in point 1.
 */
public class MinimumElementinRotatedArray {

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,1,2,3,4};
        System.out.println(findSmallestElementIndex(arr, 0 , arr.length -1));
    }

    private static int findSmallestElementIndex(int[] arr, int low, int high) {
        if (high <= low) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        if (mid < high && arr[mid + 1] < arr[mid]) {
            return mid + 1;
        }
        if (low < mid && arr[mid - 1] > arr[mid]) {
            return mid;
        }
        if (arr[mid] > arr[high]) {
            return findSmallestElementIndex(arr, mid + 1, high);
        } else {
            return findSmallestElementIndex(arr, low, mid - 1);
        }
    }
}
