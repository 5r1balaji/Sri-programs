package com.techgeek.sri.arrays;


/**
 * Solution is by using Kadane's algo
 * find the maximum possible sum at an index and store that value in a variable
 * for ex a subarray can be formed at an index with either its value at index or summation of prev indices
 *
 * It has 3 variables to compare 1 is value at index arr[i] and maxSum which is the maximum sum.
 * and sumSoFar which tells the maximum sum of subarray identified until the current index.
 *
 * when you add the value at currIndex , if it increases the sumSoFar then it means the subarray size increases.
 * if it doesn't then it means the sequence stopped at index, which can also be beginning of a new subarray.
 *
 *  at index 1 a subarray can be either -2,3 or 3 itself
 *  at index 2 a subarray can be either a maxsubarray(-2,3)  i.e -2,3,2 or 3,2 or 2
 */
public class MaximumSumSubarray {
    public static void main(String[] args) {
        int arr[]= {4,-3,2,3,4};
        System.out.println("MaxSum: "+ findMaxSum(arr));
    }

    private static int findMaxSum(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        int sumSoFar = 0;
        int start = -1, end = -1;

        for (int currIndex = 0; currIndex < arr.length; currIndex++) {
            sumSoFar = Math.max(sumSoFar + arr[currIndex], arr[currIndex]);
            if (sumSoFar == arr[currIndex]) {
                start = currIndex;
            }
            if (sumSoFar >= maxSum && currIndex - start >= end - start) {
                maxSum = sumSoFar;
                end = currIndex;
            }
        }
        System.out.print("{");
        for (int i = start; i <= end;i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print("}");
        return maxSum;
    }



}
