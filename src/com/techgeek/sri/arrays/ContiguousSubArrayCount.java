package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * The count of subarray arrays for value at each index where
 * the index i is the greatest value in the subarray and the subarray
 * should either start or end with the ith index value.
 *
 * ex [3,4,1,6,5,7]
 * for i =0 , arr[i] = 3 , subarrays possible are 3 only because the 3,4 although contigous. arr[i] is not the greatest
 * element so, res[i] = 1
 *  for i = 1, arr[i] = 4 , subarrays possible are [3,4] , 4,  [4,1] , so the count is 3
 *  res[i] = 3
 */
public class ContiguousSubArrayCount {
    public static void main(String[] args) {
        int a [] = {7,4,6,6,5,2};
        int arr[] = contigouousCounts(a);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static int[] contigouousCounts(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                res[i] += res[st.pop()];
            }
            res[i]++;
            st.add(i);
        }

        st.clear();
        int[] temp = new int[arr.length];

        for (int i = arr.length-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                int k = st.pop();
                temp[i] += temp[k];
                res[i] += temp[k];
            }
            temp[i]++;
            st.add(i);
        }
        return res;
    }
}
