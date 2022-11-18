package com.techgeek.sri.arrays;


/**
 * Max profit that can be made after executing 2 buy and sell operations
 *
 * Solution:
 * left[i] will have the maximum so far value updated , the left[i-1] the previous
 * index will be the max value uptil that index, it may be max or the difference bw
 * the min so far and the prices at the index
 *      left[i-1] or prices[i] - minSoFar
 *
 * Similarly right[i] will have maxProfit till that index traversed from right to left
 * Find the maximum stock by comparing the left stocks and right stocks
 * and finding the maximum after adding 2 of them at that point.
 *
 * TimeComplexity :
 * O(n) + o(n) + O(N) = 3 O(N)
 */
public class BestTimeToBuyandSellStockIII {
    public static void main(String[] args) {
        int []prices = {3,1,5,0,0,3,2,5};
        findBestTime(prices);
//        int[] left = new int[prices.length];
//        int[] right = new int[prices.length];
//        int minSoFar = prices[0];
//
//        for (int  i = 1; i < prices.length; i++) {
//            left[i] = Math.max(prices[i] - minSoFar, left[i-1]);
//            minSoFar = Math.min(prices[i],minSoFar);
//        }
//        int maxSoFar = prices[prices.length - 1];
//        for (int i = prices.length - 2; i > -1; i--) {
//            right[i] = Math.max(maxSoFar - prices[i], right[i + 1]);
//            maxSoFar = Math.max(maxSoFar,prices[i]);
//        }
//        int res = 0;
//        for (int i = 0; i < prices.length; i++) {
//            res = Math.max(left[i] + right[i] , res);
//        }
//
//        System.out.println(res);

    }

    private static void findBestTime(int[] prices) {

        int[] left = new int[prices.length];
        int[] right = new int [prices.length];
        int minSoFar = prices[0];
        for (int  i = 1; i < prices.length; i++) {
            left[i] = Math.max(prices[i] - minSoFar, left[i - 1]);
            minSoFar = Math.min(prices[i],minSoFar);
        }
        int maxSoFar = prices[prices.length - 1];
        for (int i = prices.length - 2; i > -1; i--) {
            right[i] = Math.max(maxSoFar - prices[i], right[i + 1]);
            maxSoFar = Math.max(maxSoFar,prices[i]);
        }
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(left[i] + right[i] , res);
        }
        System.out.println(res);
    }
}
