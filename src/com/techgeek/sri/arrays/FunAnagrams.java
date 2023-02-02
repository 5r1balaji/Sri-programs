package com.techgeek.sri.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunAnagrams {
    public static void main(String[] args) {
        ArrayList<String> abc = new ArrayList<>();
        abc.add("kope");
        abc.add("poke");
        abc.add("okpe");
        abc.add("peko");
        funWithAnagrams(abc).stream().forEach(System.out::println);
    }

    public static List<String> funWithAnagrams(List<String> text) {
        for (int i = 0; i < text.size() - 1; i++) {
            int j = i + 1;
            while (text.size() >  1 && j < text.size()) {
                boolean isAnagram = checkIfAnagram(text.get(i), text.get(j));
                if (isAnagram) {
                    text.remove(j);
                } else {
                    j++;
                }
            }

        }
        Collections.sort(text);
        return text;
    }

    private static boolean checkIfAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] first = new int[256];
        int[] second = new int[256];
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            first[a.charAt(i)]++;
            second[b.charAt(i)]++;
        }
        for (int i = 0; i < a.length(); i++) {
            if (first[a.charAt(i)] != second[a.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
}
