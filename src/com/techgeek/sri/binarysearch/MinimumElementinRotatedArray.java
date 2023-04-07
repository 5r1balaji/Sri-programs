package com.techgeek.sri.binarysearch;

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
        int[] arr = {4,4,5,6,7,8,9,3};
        System.out.println(findSmallestElementIndex(arr, 0 , arr.length -1));
    }

    private static int findSmallestElementIndex(int[] arr, int low, int high) {
        int res = arr[low];
        while (low <= high) {
            if (arr[low] < arr[high]) {
                res = arr[low];
                break;
            }
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            } else if (arr[mid] < arr[mid - 1]) {
                return arr[mid];
            } else if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
