package com.techgeek.sri.arrays;

/**
 * Longest subarray with a given sum
 */
public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr [] = { 1,2,3,4,6,15,20,-20,0,0,6,7,8,9,10};
        int rSum = 15;
        int sum = 0;
        int l =0,r =0;
        for (int i =0;i<arr.length;i++) {


            sum += arr[i];
            if (sum == rSum && i > r-l) {
                l = 1;
                r = i+1;
            } else if (sum > rSum) {
                int currSum = sum;
                int j = 0;
                while( currSum > rSum) {
                    currSum -= arr[j];
                    j++;
                    if (currSum == rSum && i+1 -(j+1) > r-l) {
                        l= j+1;
                        r = i+1;
                    }
                }
            }
        }
        System.out.println("["+l+","+r+"]");
    }
}
