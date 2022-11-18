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


        for (int i = 0;i<words.length;i++) {
            for (int j =i+1;j<words.length;j++) {
                int min = Math.min(words[i].length(),words[j].length());
                int equals = 0;
                int k;
                for ( k = 0;k < min;k++) {
                    int iChar = getIndexOf(words[i].charAt(k),order);
                    int jChar = getIndexOf(words[j].charAt(k),order);
                    if (iChar < jChar) {
                        break;
                    } else if (jChar < iChar) {
                        return false;
                    } else if (k == min-1 && words[j].length() < words[i].length() ){
                        return false;
                    }
                }

            }
        }
        return true;
    }



    private static int getIndexOf(char ch,String order) {
        return order.indexOf(ch);
    }
    public static void main(String[] args) {
        String list[] = {"word","word"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(list,order));
    }
}
