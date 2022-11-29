package com.techgeek.sri.binarysearch;

public class FindStartEndofElementX {
    public static void main(String[] args) {
        int arr[] ={ 1,2,3,3,3,3,4,4,4,5,5,6,6,6,6};
        int x = 1;
        int first = findPosition(arr,x);
        int last = findPosition(arr,x+1);
        if (last == -1) {
            last = arr.length;
        }
        System.out.println(first+","+(last-1));
    }

    private static int findPosition(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        int res = -1;
        while(low <= high) {
            int mid = low + (high-low  ) /2;
             if (arr[mid] >= x) {
                 res = mid;
                high = mid -1;
            } else{
                low = mid +1;
            }

        }
        return res;
    }
}
