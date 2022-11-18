package com.techgeek.sri.arrays;

import java.util.HashMap;

public class ContinuousSumDivisibleByK {
    public static void main(String[] args) {
        int arr[] = {2,4,5,0};
        System.out.println(checkSubarraySum(arr,6));
    }

    public static boolean checkSubarraySum(int[] arr, int k) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0;i < arr.length;i++) {
            sum = (sum + arr[i]) % k;
            if (map.containsKey(sum) && i - map.get(sum)  >= 2) {
                return true;
            } else {
                map.putIfAbsent(sum,i);
            }
        }
        return false;

    }
}
