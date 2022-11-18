package com.techgeek.sri;

public class BestTimeToBuyandSellStockIV {

    public static void main(String[] args) {
        /*0 0 2 2 3 6
        6 6 5 5 3 0*/
       int stock[] = {6,1,3,2,4,7};
       int k = 2;
        System.out.println(maxProfit(k,stock));
    }
    public static int maxProfit(int k, int[] prices) {
        int[] profit = new int [(prices.length / 2) + 1];
        int maxProfit = 0;
        int min = prices[0];
        int minIndex = 0;
        int j = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            if (prices[i] - min > profit[j - 1 ] ) {
                profit[j] = prices[i] - min;

                if (k == 0 && profit[j] > profit[minIndex]) {
                    maxProfit = maxProfit - profit[minIndex] + profit[j];
                    if (j > 0 && profit[j] < profit[minIndex]) {
                        minIndex = j;
                    }
                } else {
                    maxProfit += profit[j];
                    k--;
                    if (j > 0 && profit[j] < profit[minIndex]) {
                        minIndex = j;
                    }
                }

                //min = prices[i];
                j++;

            }
        }

        return maxProfit;
    }
}
