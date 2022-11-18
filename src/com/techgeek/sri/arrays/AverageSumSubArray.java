package com.techgeek.sri.arrays;

import java.util.ArrayList;

/**
 * Find subarrays whose sum is greater than the remaining elements in the array.
 *
 * [3,4,2]
 *
 * output :
 * [ [1,2],[2,2],[1,3]]
 * explanation
 *  [3,4 ],4,[3,4,2]
 */
public class AverageSumSubArray {
    public static void main(String[] args) {
       int input[] = {3,4,2,7,1};
       int total = 0;
       for (int i =0;i<input.length;i++) {
           total += input[i];
       }
       int curr = 0;

       ArrayList<ArrayList<Integer>> values = new ArrayList<>();
       for (int i = 0; i < input.length; i++) {
           curr += input[i];
           if (curr > total - curr) {
               ArrayList<Integer> c = new ArrayList<>();
               c.add(1);
               c.add(i + 1);
               values.add(c);
               if (i == 0) {
                   continue;
               }
           }
            if (input[i] > total-curr && i !=input.length-1) {
               ArrayList<Integer> in = new ArrayList<>();
               in.add(i+1);
               in.add(i+1);
               values.add(in);
           }
       }
       int i = 0;
       while(i < values.size()) {
           ArrayList<Integer> k = values.get(i);
           System.out.print("[");
           for (int j =0;j< k.size();j++) {
               System.out.print(k.get(j)+",");
           }
           System.out.print("]");
           i++;
       }
    }
}
