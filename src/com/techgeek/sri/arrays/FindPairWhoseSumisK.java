package com.techgeek.sri.arrays;

import java.util.HashMap;

public class FindPairWhoseSumisK {
    public static void main(String[] args) {
        int arr[] = {4,-5,3,7,8,-9};
        int sum = -14;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0;i<arr.length;i++) {
            if (map.containsKey(arr[i])) {
                System.out.println("{"+map.get(arr[i])+","+arr[i]+"}");
            } else {
                map.put(sum-arr[i],arr[i]);
            }
        }
    }
}
