package com.techgeek.sri.dynamicprogramming;


import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 */
public class WordBreakII {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat","cats","and","sand","dog"};
        HashSet<String> words = new HashSet<>(Arrays.asList(wordDict));

        Map<String,List<String>> memo = new HashMap<>();
        List<String> res = findWordBreaks(s, words, 0, memo);
        res.stream().forEach(System.out::println);

    }

    private static List<String> findWordBreaks(String s, HashSet<String> dict, int index, Map<String, List<String>> memo) {
        if (index < s.length()) {
            if (memo.containsKey(s.substring(index))) {
                return memo.get(s.substring(index));
            }
            String compare = "";
            List<String> curr = new ArrayList<>();
            for (int i = index; i < s.length(); i++) {
                compare += s.charAt(i);
                if (dict.contains(compare)) {
                    List<String> k = findWordBreaks(s, dict, i + 1 , memo);
                    if (k != null) {
                        for (String str : k) {
                            curr.add(compare + " " + str);
                        }
                    } else {
                        curr.add(compare);
                    }

                }
            }
            memo.put(s.substring(index),curr);
            return curr;
        }
       return null;
    }
}
