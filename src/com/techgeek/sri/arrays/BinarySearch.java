package com.techgeek.sri.arrays;

public class BinarySearch {
    public static void main(String[] args) {
        //
        int[] nums = {4,5,6,7,7,8,9,9,11};
        int target = 9;
        System.out.println(findPosition(nums,9));
        System.out.println (findPosition(nums,10));
    }
    static  int findPosition(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
