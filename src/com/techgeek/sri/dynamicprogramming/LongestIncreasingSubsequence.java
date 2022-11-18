package com.techgeek.sri.dynamicprogramming;

import java.util.Arrays;

/**
 * Subarray is not continguous
 * [10,22,9,41,50,60]
 *   1  1  1  1  1  1
 *    j= 0  i= 1
 *    10 | 22 9 41 50 60
 *    j=0 | i=3
 *    10 22 9 | 41 50 60  memo[3] < memo[0] && memo [3] < memo[2] && memo[3] < memo[1]
 *  Solution :
 *    10,22,41,50,60 = 5
 *    Length is 5
 *
 *    Time complexity is O(N^2)
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {5,8,7,6,9};

        int memo[] = new int[arr.length];
        for (int i = 0;i < arr.length;i++) {
            memo[i] = 1;
        }

        for (int i = 1;i < arr.length;i++) {
            for (int j =0 ;j < i;j++) {
                if (arr[j] < arr[i] && memo[i] < memo[j]+1 ){
                    memo[i] = memo[j]+1;
                }
            }
        }

        System.out.println(Arrays.stream(memo).max().orElse(1));

    }
}
