package com.techgeek.sri;

/**
 * KMP Partial Table
 * solution:
 * Creating a pattern table where if i and j index values are equal increment i and j
 * if not fallback j to the index where it was matching before. i.e decrement j = arr[j-1]
 * and compare charAt(j) and charAt(i) and do this until they are equal if not increment i and
 * complete the loop.
 *
 * The reason why we are creating this array is because we want to find at which point the pattern of current index j matches
 * with the actual string charAt(i) before in the pattern string
 * abxabcabc
 * i.e when abcaby
 * In the pattern sequence ab at index 3 already occurs 0 but when mismatch happens , we can simply find out till
 * which index was the actual string matched with the sequence by taking the array value at j-1 th index
 * the value at arr[i] represents from which position after the current match should you compare .
 * When a match happens at jth index, i.e at i= 2 and j= 2  ( x != c) uptil index 2 in pattern there is no repetition
 * or substring of the chars doesnt exist in the pattern.
 * so the comparison shud again start from index 0.
 *
 * So j= 0 and i= 3
 * from index i = 3 and i = 7 it matches with j
 * so the jth value becomes 5
 * at i = 8 and j = 6 (c != y) so arr[j-1] will represent at which point b exists in the pattern + 1
 * i.e b exists in index 1 so uptil chars at index 1 already matches with the actual string so the comparison
 * should be resumed from the next index after the match so plus 1 .
 * So the comparison will be resumed from j= 3 and i = 8
 *
 * Time Complexity
 * O(M + N)
 * Where M and N are size of pattern and actual string
 */
public class FindSubStringinString {

    public static void main(String[] args) {
        String str = "abxabcabcabxzdvsdf";
        String pattern = "abcaby";
        int[] pat = getPattern(pattern);
        System.out.println(findSubstringPresent(str,pattern, pat));
    }

    private static int[] getPattern(String pattern) {
        int[] arr = new int[pattern.length()];
        int i = 1;
        int j = 0;
        while (i < arr.length ) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                arr[i++] = j + 1;
                j++;
            } else {
                if (j - 1 >= 0) {
                    j = arr[j - 1];
                } else {
                    i++;
                }
            }
        }
        return arr;
    }

    /**
     * Pattern matching using the array (constructed using pattern and where each character in pattern
     * exists as a prefix in itself) with the actual string . Using the indices mentioned in the string
     * we can easily compare values from pattern and actual string.
     * @param str
     * @param pattern
     * @param arr
     * @return
     */
    private static boolean findSubstringPresent(String str, String pattern, int[] arr) {
        int i = 0, j = 0;
        int index = -1;
        while (i < str.length() && j < pattern.length()) {
            if (str.charAt(i) == pattern.charAt(j)) {
                if (index == -1) {
                    index = i - arr[j];
                }
                i++;
                j++;
            } else {
                if (j - 1 >= 0) {
                    j = arr[j - 1];
                    index = i - j;
                } else {
                    index = -1;
                    i++;
                }

            }
        }
        System.out.println(index +","+ (i-1) );
        return index != -1;
    }
}
