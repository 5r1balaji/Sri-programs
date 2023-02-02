package com.techgeek.sri;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 */
public class AlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {


        for (int i = 0; i < words.length - 1;i++) {
            String first = words[i];
            String second = words[i + 1];
            for (int j = 0;j < first.length();j++) {
                if (second.length() == j) {
                    return false;
                }
                if (first.charAt(j) != second.charAt(j)) {
                    if ( getIndexOf(second.charAt(j), order) < getIndexOf(first.charAt(j), order))  {
                        return false;
                    }
                    break; // When the characters are not equal but they are in the correct
                    // order then the remaining comparison is not required because the dictionary is in the next alphabet
                    // so the comparison should be made with the next string
                }
            }
        }
        return true;
    }



    private static int getIndexOf(char ch,String order) {
        return order.indexOf(ch);
    }
    public static void main(String[] args) {
        String list[] = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(list,order));
    }
}
