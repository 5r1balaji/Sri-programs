package com.techgeek.sri.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest subarray with a given sum
 * if total value until the total + requiredSum = total + valueAtCurrIndex , it means there exists an index in the
 * array where the total sum until that point is not required from the total.
 */
public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,7,15};
        int rSum = 9;
        int sum = 0, maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                int diff = i - map.get(sum);
                if (diff > maxSum) {
                    maxSum = diff;
                }
            } else {
                map.put(sum + rSum, i);
            }
        }
        System.out.println(maxSum);
    }
}
