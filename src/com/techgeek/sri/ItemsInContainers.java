package com.techgeek.sri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  |**|*|**
 *  1,5 -2
 *  1,6 - 3
 *
 *  Find the number of items i.e '*' enclosed by pipes.
 *  within the given indices 1,5 and 1,6
 *
 *  Solution:
 *  create an array with each index maintaining the number of stars since the last compartment index.
 *  i.e at position i = 3, the first compartment the number of stars = 2
 *  so memo[3] = 2;
 *
 *  at i = 5 , the last compartment value = 3 and memo[3] = 2
 *  so memo[5] = memo[lastcompartment] + number of stars since the last compartment index
 *  memo[5] = 2 + 1 = 3
 *
 *  nearest is a position which holds the nearest compartment for the index on the right side.
 *  It can the index itself or the position of the index which holds the updated nearest index
 *  i.e at position i = 1, * , nearest  = 1
 *  no matter how many stars get encountered after that will have nearestCompartment[i] = 1
 *
 *  Once  a compartment is found we can update the position of the 'nearest' index with the value
 *  ' the index of the compartment found '
 *  i.e nearestCompartment[nearest] = i (the current index which is the compartment)
 *
 *  Time Complexity:
 *  O(N) where N is the size of the string.
 */


public class ItemsInContainers {

    public static void main(String[] args) {
        String s = "|*||||*|**|";
        //3,8
        int pipe = 0;
        int star = 0, nearest = -1;
        int[] memo = new int[s.length()];
        int lastCompartmentIndex = 0;
        int[] nearestCompartment = new int [s.length()];
        for (int i =0;i< s.length();i++) {
            if (s.charAt(i) == '|') {
                pipe++;
                if (pipe == 2) {
                    memo[i] = memo[lastCompartmentIndex] + star;
                    pipe--;
                    nearestCompartment[lastCompartmentIndex] = lastCompartmentIndex;
                    if(nearest > -1){
                        nearestCompartment[nearest] = i;// Updating the value for nearest Compartment index
                                            // for all those indices since the last compartment
                    }
                    lastCompartmentIndex = i;
                    nearest = -1;
                }
                star = 0;
            } else if (s.charAt(i) == '*') {
                star++;
                if (nearest < 0) {
                    nearest = i;
                }
            }
            nearestCompartment[i] = nearest;// Updates the index to refer when a compartment is found.
            memo[i] = memo[lastCompartmentIndex];
        }

        List<Integer> startIndice = new ArrayList<>();
        startIndice.add(1);
        startIndice.add(3);
        List<Integer> endIndice = new ArrayList<>();
        endIndice.add(5);
        endIndice.add(11);

       for (int i = 0;i < startIndice.size();i++) {
           int start = startIndice.get(i)-1;
           int end = endIndice.get(i)-1;
           if (nearestCompartment[start] >= 0) { // if it is less than 0, it means no compartment found
               start = nearestCompartment[nearestCompartment[start]];// Refers the index Of the nearest Compartment at that index
           } else {
               start = -1;
           }
           int res = start < 0 ? 0 : memo[end]- memo[start];
           System.out.print(res+",");
       }
        //Arrays.stream(memo).forEach(System.out::println);
    }
}
