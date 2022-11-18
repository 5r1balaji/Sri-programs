package com.techgeek.sri.dynamicprogramming;

/**
 *   In addition to I program we need to decode extra char called *
 *   which represents universal char that can have 9 ways of decoding
 *   i.e 1,2,3,4,5,6,7,8,9
 *   input
 *   1*
 *    output
 *    18
 *    9  + 1 *9 = 18
 *    1) 11,12,13,14,15,16,17,18,19
 *    2) 1,1, 1,2, 1,3, 1,4,
 *
 *    1*14
 *    1,*,1,4  - 9
 *    1,*,14 - 9
 *    1,*1,4 - 2
 *    1*,14 - 9
 *    1*,1,4 - 9
 *
 *    12*
 *    1,2,* = 9
 *    1,2* = 6
 *    12,* = 9
 *
 */
public class PossibleWaysOfDecodingStringII {
    public static void main(String[] args) {
        String str = "********";
        int[] memo = new int [str.length()+1];
        System.out.println(decodeWays(str,str.length(),memo));

    }

    public static int decodeWays(String str, int numOfChars, int[] memo) {
        if (memo[numOfChars] > 0) {
            return memo[numOfChars];
        }
        if (str.length() == 1) {
            if (str.charAt(0) == '0') {
                return 0;
            } else if (str.charAt(0) == '*') {
                return 9;
            }
            return 1;
        }
        if (numOfChars == 0) {
            return 1;
        }

        if (str.charAt(0) == '0') {
            return memo[numOfChars];
        }

        int s = str.length() - numOfChars;
        int curr = 1;
        if (str.charAt(0) == '*') {
            curr = 9;
        }
         int res = curr * decodeWays(str.substring(s + 1), numOfChars - 1, memo);

        if (s+2 <= str.length()) {
            int currentWays = 1;
            char first = str.charAt(0);
            char second = str.charAt(1);

            if (second == '*' ) {
                if (first == '1') {
                    currentWays = 9;
                } else if (first == '2') {
                    currentWays = 6;
                } else if (first == '*'){
                    currentWays = 15;
                } else {
                    currentWays = 0;
                }
            }else if (first == '*' ) {
                if (second >= '0' && second <= '6') {
                    currentWays = 2;
                } else if (second > '6' && second <= '9') {
                    currentWays = 1;
                } else {
                    currentWays = 15;
                }
            } else {
                int k = Integer.parseInt(str.substring(0,s + 2));
                if ( k > 26) {
                    currentWays = 0;
                }
            }

            if (currentWays > 0) {
                res += currentWays * decodeWays(str.substring(s+2), numOfChars - 2, memo);
            }

        }
        memo[numOfChars] = res;
        return memo[numOfChars];
    }
}
