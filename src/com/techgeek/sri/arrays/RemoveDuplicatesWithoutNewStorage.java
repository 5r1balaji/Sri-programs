package com.techgeek.sri.arrays;

import java.util.Arrays;

public class RemoveDuplicatesWithoutNewStorage {


    public static void main(String[] args) {
        int arr [] = {4,5,5,6,6,6,8,9,12};
        // 45 67899912

        int j = 0;

        for (int i =0;i<arr.length;i++){
            if (arr[i] != arr[j]) {
                arr[++j] = arr[i];
            }
        }

        Arrays.stream(arr).forEach(System.out::println);

    }
}
