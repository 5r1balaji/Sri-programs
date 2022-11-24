package com.techgeek.sri;

import java.util.Stack;

/**
 * Given a string containing only R and L. Find the number of balanced substrings(equal number of L’s and R’s)
 * you will encounter where you can traverse only in the left-right direction.
 * Substrings should not overlap.
 *
 * Example 1: RLRRLLRLRL  Answer: 4 (RL, RRLL, RL, RL)
 *
 * Example 2: LLLLRRRR  Answer:1 (LLLLRRRR)
 *
 * Example 3: RLLLLRRRLR  Answer:3 (RL, LLLRRR, LR)
 */
public class BalancedSubstrings {
    public static void main(String[] args) {
        String s = "RLRLRLRL";
        Stack<Integer> index = new Stack<>();
        Character comp = s.charAt(0);
        int k = -1;
        int firstIndexOfChars = -1;
        int i;
        for ( i = 0;i < s.length();i++) {
            if (index.isEmpty()) {
                firstIndexOfChars = i;
                comp = s.charAt(i);
            }
            if (s.charAt(i) == comp ) {
                if (k > -1) {
                    index = new Stack<>();
                    System.out.println(s.substring(k,i));
                    k = -1;
                    comp = s.charAt(i);
                }
                index.add(i);
            } else {
                   int top = index.pop();
                   if (firstIndexOfChars == top) {
                       k = -1;
                       System.out.println(s.substring(firstIndexOfChars,i+1));
                   } else {
                       k = top;
                   }
            }
        }

        if (k > -1) {
            System.out.println(s.substring(k,i));
        }

    }
}
