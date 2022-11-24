package com.techgeek.sri.dynamicprogramming;


import java.util.*;
import java.util.stream.Collectors;

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
        String s = "pineapplepenapple";
        String[] wordDict = {"apple","pen","applepen","pine","pineapple"};
        HashSet<String> words = new HashSet<>(Arrays.asList(wordDict));

        Map<String,Set<String>> memo = new HashMap<>();
        Set<String> res = findWordBreaks( s, words, memo);
        res.stream().forEach(System.out::println);

    }

    private static Set<String> findWordBreaks(String subString, HashSet<String> dict, Map<String, Set<String>> memo) {
        if (subString.isEmpty()) {
            return Collections.emptySet();
        }

        if (memo.containsKey(subString)) {
            return memo.get(subString);
        }

        StringBuilder currDictionaryWord = new StringBuilder();
        Set<String> wordCombinations = new HashSet<>();

        for (int index = 0; index < subString.length(); index++) {
            currDictionaryWord.append(subString.charAt(index));
            if (dict.contains(currDictionaryWord.toString())) {
                Set<String> preComputedWordBreaks = findWordBreaks(subString.substring(index + 1), dict, memo);
                wordCombinations.addAll(constructPreComputedWordBreaks(preComputedWordBreaks, currDictionaryWord));
            }
        }

        memo.putIfAbsent(subString, wordCombinations);
        return memo.get(subString);
    }

    private static Set<String> constructPreComputedWordBreaks(Set<String> preComputedWordBreaks, StringBuilder currDictionaryWord) {
        if (preComputedWordBreaks.isEmpty()) {
            return Collections.singleton(currDictionaryWord.toString());
        }
        return preComputedWordBreaks.stream().map(dictionaryWord -> currDictionaryWord + " " + dictionaryWord).collect(Collectors.toSet());
    }
}
