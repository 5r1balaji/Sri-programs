package com.techgeek.sri.arrays;

public class CountingBit {
    public static void main(String[] args) {
        int num = 5;
        int arr[] = new int[num + 1];
        int curr = 0;
        for (int i = 1;i <= num;i++) {
            int s = (int)Math.pow(2,curr);
            arr[i] = arr[s-i] + 1;
            if (s == i) {
                curr++;
            }
        }

        for (int i = 0;i <= num;i++) {
            System.out.println(arr[i]);
        }
    }
}
