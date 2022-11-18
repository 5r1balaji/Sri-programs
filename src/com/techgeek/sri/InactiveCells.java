package com.techgeek.sri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InactiveCells {
    public static List<Integer> cellCompete(int[] states, int days)
    {
        int i =0;
        int states1[] = Arrays.copyOf(states,states.length);
        int a,b;
        while(days > 0) {
            if (i < states.length) {
                if (i-1 < 0) {
                    a = 0;
                } else {
                    a = states[i-1];
                }
                if (i+1 == states.length) {
                    b = 0;
                } else {
                    b = states[i+1];
                }
                states1[i] = a ^ b;
                i++;
            }
            if (i == states.length ) {
                days --;
                states = Arrays.copyOf(states1,states1.length);
                if (days  > 0){
                    i =0;
                } else {
                    break;
                }
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        for (int k =0;k < states.length;k++) {
            res.add(states[k]);
        }
        return res;
        // WRITE YOUR CODE HERE
    }

    public static void main(String[] args) {
       // int arr[] ={1,0,0,0,0,1,0,0};
        int arr[] = {1,1,1,0,1,1,1,1};
        System.out.println(cellCompete(arr,2));
    }
}
