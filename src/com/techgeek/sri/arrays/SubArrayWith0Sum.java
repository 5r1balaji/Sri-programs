package com.techgeek.sri.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *  arr = [4,2,-3,-1,0,4]
 *  output : {0}
 *          {-3,-1,0,4}
 *    if sum == 0 print the subset directly
 *    sum of aggregated indexes are stored till the current index in the loop is stored in hashmap (i.e sum of all values from 0 to i = sum)
 *    sum of n indexes = 13  and  the first 0 to i indexes value = 13 (for ex 0 - 6 = 13 and in hashmap 0 -3 = 13
 *    means indexes from 4 to 6 will be 0 ( line number 30 depicts that)
 */
public class SubArrayWith0Sum {

    public static void main(String []args){

        //int[] arr = {4,2,-3,-1,-2,6,-3,-1,0,4};
        int x = 31; // change it to 0 for 0 subarray
        int[] arr = {1,2,3,4,6,15};
        Map<Integer, Integer> sumMap = new HashMap<>();
        Integer sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];//9
            if (sum == x) {
                printSubArray(arr, 0, i);
            }
            if (sumMap.containsKey(sum)) {
                printSubArray(arr, sumMap.get(sum) + 1 , i);// Removing the added element from the index
            }
            sumMap.put(sum + x, i);// Add the required displacement needed to find our required sum

        }
    }
    public static void printSubArray(int[] arr, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
