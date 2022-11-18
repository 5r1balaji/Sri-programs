package com.techgeek.sri.arrays;

import java.util.HashMap;

/**
 * Question is to print the number of contiguous subarrays that can be found with a given sum.
 * input
 * 3,2,1,2,1
 * 3
 * output
 * 3
 * explanation
 * 3
 * 2,1
 *
 * Solution:
 * Add the current sum as sum += arr[i] at each index.
 * At every index find if the current sum is subtracted by K already exists in the hashmap
 *
 * The hashmap will maintain the count of currentSum
 * When the sum is subtracted by k , it means that the K occurred again after it existed at hashmap added index
 *
 *
 *
 */
public class NumberOfContiguousSubArraysWhoseSumisK {
    public static void main(String[] args) {
        int arr [] = {3,2,1,2,1};
        int k = 3;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        for (int i = 0 ;i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(res);
    }
}
