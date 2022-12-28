package com.techgeek.sri;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Remove the index of the non repeated character from the hashset encountered until the repeated character index.
 *
 * Solution:
 * Is to use 2 pointers i  j where j denotes the first index of the non-repeating substring. if it repeats then
 * update the j to the next index
 * For each iteration update the int[] with char indexes representing any of the 256 characters.
 * and update the value of the character index with the current occurence i.
 *
 * charIndex[s.charAt(i])] >= j)
 * if the startIndex of the non repeating substring i.e j is greater than the index of the char it is last found.
 * That means the character is not in the substring. even though it repeats in the whole string , it does not appear
 * in the substring identified.
 *
 * ex 't' is found at index 0 and index 6, even though it repeats in the string , the substring 'muzxt' starting at index 2
 * is greater than the index it was found previously i.e 0, it means it is not appearing in the identified substring 'muzxt'
 */
public class LengthOfLongestNonRepeatingSubstring {

    public static void main(String[] args) {
        String s = "tmmuzxt";
        System.out.println(findMax(s));
    }

    private static int findMax(String s) {
        int[] charIndex = new int[26];
        Arrays.fill(charIndex , -1);
        int j = 0;
        int maxLongest = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charIndex[ch] >= j) {
                j = charIndex[ch] + 1;
            } else {
                int currLongest = i - j + 1;
                maxLongest = Math.max(currLongest, maxLongest);
            }
            charIndex[ch] = i;
        }
        return maxLongest;
    }
}
