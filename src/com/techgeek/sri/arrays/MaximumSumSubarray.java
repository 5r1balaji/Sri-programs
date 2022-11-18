package com.techgeek.sri.arrays;


/**
 * Solution is by using Kadane's algo
 * find the maximum possible sum at an index and store that value in a variable
 * for ex a subarray can be formed at an index with either its value at index or summation of prev indices
 *  at index 1 a subarray can be either -2,3 or 3 itself
 *  at index 2 a subarray can be either a maxsubarray(-2,3)  i.e -2,3,2 or 3,2 or 2
 */
public class MaximumSumSubarray {
    public static void main(String[] args) {
        int arr[]= {8,-19,5,-4,20};
        System.out.println(findMaxSum(arr));
    }

    private static int findMaxSum(int[] arr) {

        int maxSoFar= arr[0],sum = arr[0];
        int start = 0,end =0;
        for (int i = 1;i < arr.length;i++) {
            maxSoFar = Math.max(maxSoFar + arr[i],arr[i]);// Either the current index or max so far with current index;
            if (maxSoFar == arr[i]) {
                start = i;
            }
            if ( maxSoFar >= sum ) {
                sum =  maxSoFar;
                end = i;
            }
        }
        for (int i = start;i<=end;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        return sum;
    }



}
