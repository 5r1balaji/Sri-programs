package com.techgeek.sri;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove the index of the non repeated character from the hashset encountered until the repeated character index.
 */
public class LengthOfLongestNonRepeatingSubstring {

    public static void main(String[] args) {
        String s = "abcbde";
        System.out.println(findMax(s));
    }

    private static int findMax(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
