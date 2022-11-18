package com.techgeek.sri.dynamicprogramming;

/**
 * Dynamic Programming
 *
 * input = "12345"
 * output :
 * 3
 * explanation
 * 1 -a
 * 12 - l
 * 2- b
 * 3-c
 * 4 -d
 * 5- e
 *
 * 1 , 2345 -> 2 - 345 -> 23 -> 45 - 3
 *
 *
 * if input is empty... then the output is 1
 * if input contains 0... then the output is 0
 *
 * The question is to find the number of ways to decode and not the no. of possible messages....
 * so the ex 121 , the output is 3
 * 1 - 21 -> 1 ,2,1
 * 12,1
 * 1,21
 *
 */
public class PossibleWaysOfDecodingString {

    public static void main(String[] args) {
        String input = "1204";
        int [] mem = new int[input.length()+1];
        int output = decodes(input,input.length(),mem);
        System.out.println(output);
       // System.out.println(decodeWays(input,input.length(),mem));

    }

    public static int decodes(String input, int length, int[] mem) {
        if (length == 1 || length == 0) {
            return 1;
        }

        int firstNIndex = input.length() - length + 1;
        if (mem[firstNIndex] != 0) {
            return mem[firstNIndex];
        }
        int ways;
        if (input.charAt(firstNIndex - 1) == '0') {
           ways = 0;
        } else {
            ways = decodes(input, length - 1 , mem);
            if (firstNIndex < input.length()) {
                ways += decodes(input, length - 2, mem);
            }
        }

        mem[firstNIndex] = ways;
        return mem[firstNIndex];
    }







    private static int anotherDecodeWays(String input, int length, int[] mem) {
        if (length == 0) {
            return 1;
        }
        int currIndex = input.length() - length;
        if (mem[currIndex] > 0) {
            return mem[currIndex];
        }
        int counts = possibleCounts(input, length - 1, mem);
        if (input.charAt(currIndex) != '0' && currIndex + 1 < input.length()) {
            counts += possibleCounts(input, length - 2, mem);
        }
        mem[currIndex] = counts;
        return mem[currIndex];
    }

    /**
     * The index positions are determined by length() - (length() -i)
     * where i is the ith recursion .
     * for 1214
     * initially s = 0 (length()- length() = 0
     * n =  n-1 so s = 1 (length() - (length()-1) =
     *
     * length is determined for memoizations i.e for substring of 'n' chars the maximum outcomes.
     * The outcomes are found from the last index positions.
     *  i.e  4 -> 14 -> 214  -> 1214
     *
     *
     * @param input
     * @param length
     * @param mem
     * @return
     */
    private static int possibleCounts(String input, int length, int[] mem) {
        if (length == 0) {
            return 1;
        }
        int currIndex = input.length() - length;
        if (mem[length] > 0) {
            return mem[length];
        }
        if (input.charAt(currIndex) == '0') {
            return 0;
        }
        int counts = possibleCounts(input, length - 1, mem);
        String str = input.substring(currIndex, Math.min(currIndex + 2 , input.length() - 1));
        if (currIndex <= input.length() - 2 && Integer.parseInt(str) <= 26) {
            counts += possibleCounts(input, length - 2, mem);
        }
        mem[length] = counts;
        return mem[length];
    }
    /**
     * written by me
     * @param str
     * @param numOfChars number of remaining chars in the given string
     * @param memo
     * @return
     */
    public static int decodeWays(String str, int numOfChars, int[] memo) {

        if (str.length() == 1) {
           if (str.charAt(0) == '0') {
               return 0;
           }
            return 1;
        }
        if (numOfChars == 0) {
            return memo[numOfChars];
        }

        if (memo[numOfChars] > 0) {
            return memo[numOfChars];
        }
        if (str.charAt(0) == '0') {
            return memo[numOfChars];
        }

        int s = str.length() - numOfChars;

        memo[numOfChars] = decodeWays(str.substring(s + 1), numOfChars - 1, memo);

        if (s + 2 <= str.length()) {
            int k = Integer.parseInt(str.substring(0, s + 2));
            if (k >= 1 &&  k <= 26) {
                memo[numOfChars] = 1 + decodeWays(str.substring(s + 2), numOfChars - 2, memo);
            }
        }
        return memo[numOfChars];
    }
}
