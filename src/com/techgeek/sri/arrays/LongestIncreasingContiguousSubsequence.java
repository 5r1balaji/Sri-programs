package com.techgeek.sri.arrays;

/***
 * Longest increasing subsequence where the subsequence is Contiguous
 * [10,2,9,3,41,50,41,60]
 * Ans :
 *     9,3,41,50 = 4
 */
public class LongestIncreasingContiguousSubsequence {
    public static void main(String[] args) {
        int arr[] = {10,12,9,13,41,50,41,60};
        int memo[] = new int [arr.length];
        memo[0] = 1;
        int longest = 0;
        for (int j =1 ;j <arr.length;j++) {
            if (arr[j] > arr[j-1]) {
                memo[j] = memo[j-1] + 1;
            } else {
                memo[j] = 1;
            }
            if (longest < memo[j]) {
                longest = memo[j];
            }
        }
        System.out.println(longest);
    }
}
