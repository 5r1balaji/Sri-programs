package com.techgeek.sri;


/**
 * Input: Given string :"forgeeksskeegfor",
 * Output: "geeksskeeg"
 *
 * Input: Given string :"Geeks",
 * Output: "ee"
 *
 * Time Complexity O(N^2)
 */
public class LongestPalindromSubstring {

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
        System.out.println(longestPalindrome(str, 0 , 0));
    }

    /**
     * The idea is explore all substrings from each index in the string.
     * Only expand as long as the left and right values are equal.
     * Find the length of the substring found on each index expansion from centre towards left and right.
     * if the substring length is greater than the longestIndex so far,
     * then update the start and end index of the longest substring.
     *
     * The while loop finishes with index outside the array boundaries i.e start--, end++, so reduce the index by 1
     * i.e (end-start-1 ) becuase start = -1 and end = 7 for longest index ex.
     *
     * To find the index, reduce the maxLengthPalindromicSubstring by 1 so that the finding index will start from 0th place.
     *
     *
     * @param str
     * @param longestSubstringIndexStart
     * @param longestSubstringIndexEnd
     * @return
     */
    private static String longestPalindrome(String str, int longestSubstringIndexStart, int longestSubstringIndexEnd) {
        if (str.length() < 1) {
            return str;
        }

        for (int i = 0; i < str.length();i++) {
            int len1 = expand(str, i, i);
            int len2 = expand(str, i, i + 1);
            int maxLengthPalindromicSubstring = Math.max(len1, len2);
            if (longestSubstringIndexEnd - longestSubstringIndexStart + 1 < maxLengthPalindromicSubstring ) {
                longestSubstringIndexStart = i - (maxLengthPalindromicSubstring - 1)/ 2;
                longestSubstringIndexEnd = longestSubstringIndexStart + maxLengthPalindromicSubstring ;
            }

        }
        return str.substring(longestSubstringIndexStart, longestSubstringIndexEnd );
    }

    private static int expand(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int [n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        int maxLength = 1, start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                maxLength = 1;
                start = i;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; n - (j + i) > 0 ; j++) {
                if (s.charAt(j + i) == s.charAt(j) && dp[j + 1][ j + i - 1] == 1) {
                    dp[j][j + i] = 1;
                    if (i > maxLength) {
                        maxLength = i;
                        start = j;
                    }
                }
            }
        }

        return s.substring(start , start + maxLength + 1);
    }

}
