package com.techgeek.sri.dynamicprogramming;


/**
 * Solution is to use memoization by taking ways of previous denomination plus
 * including the current denomination
 *
 * The current denomination can taken by removing the current denomination value from the Sum
 * i.e if u require change for 6 rs..
 * the current denomination is 5 then remove 6 - 5  = 1
 * so when the value is 1 the number of combinations to achieve 1
 * denomination = { 1, 2, 5} , sum = 6
 * for sum = 6 = ways to achieve the sum using previous denomination  + current denomination
 *
 *
 */
public class CoinChangingWays {

    public static void main(String[] args) {
        int sum = 7;
        int[] arr = {2, 3, 5};
        System.out.println(findWays(sum, arr));
    }

    private static int findWays(int sum, int[] arr) {

        int [][] dp = new int[arr.length][sum + 1];
        for (int i  = 0;i < arr.length ;i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i] > j ) {
                    if (i > 0)
                        dp[i][j] = dp[i - 1][j];
                } else {
                    int prev = i > 0 ? dp[i - 1][j] : 0;
                    dp[i][j] = prev + dp[i][j - arr[i]];
                }
            }
        }
        return dp[arr.length-1][sum];
    }
}
