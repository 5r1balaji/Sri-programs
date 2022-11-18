package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LongestSumDivisibleByK {

        // Recursive function to return the count
// of subsets with sum equal to the given value
        static int longSubarrWthSumDivByK(int arr[],
                                          int n, int k)
        {
            // unodered map 'um' implemented as
            // hash tabl
            HashMap<Integer, Integer> um= new HashMap<Integer, Integer>();

            // 'mod_arr[i]' stores (sum[0..i] % k)
            int mod_arr[]= new int[n];
            int max = 0;
            int curr_sum = 0;

            // traverse arr[] and build up the
            // array 'mod_arr[]'
            for (int i = 0; i < n; i++)
            {
                curr_sum += arr[i];

                // as the sum can be negative,
                // taking modulo twice
                mod_arr[i] = ((curr_sum % k) + k) % k;
            }

            for (int i = 0; i < n; i++)
            {
                // if true then sum(0..i) is
                // divisible by k
                System.out.println(mod_arr[i]+"max:"+max);
                if (mod_arr[i] == 0)
                    // update 'max'
                    max = i + 1;

                    // if value 'mod_arr[i]' not present in 'um'
                    // then store it in 'um' with index of its
                    // first occurrence
                else if (um.containsKey(mod_arr[i]))
                    um.put(mod_arr[i] , i);

                else{
                    // if true, then update 'max'
                    int c = i - um.get(mod_arr[i]);
                    if (max < c) {
                        max = i - um.get(mod_arr[i]);
                    }
                }

                printVal(um.get(mod_arr[i]),i,arr);
            }



            // required length of longest subarray with
            // sum divisible by 'k'
            return max;
        }

    private static void printVal(Integer l, int n,int a[]) {
            for(int i = l+1 ;i<= n ; i++) {
                System.out.println(a[i]+",");
            }
    }

    public static void main (String[] args)
    {
        int arr[] = {1, 7, 3, 2, 3, 3};
        int n = arr.length;
        int k = 3;

        System.out.println("Length = "+
                longSubarrWthSumDivByK(arr, n, k));

    }
}

