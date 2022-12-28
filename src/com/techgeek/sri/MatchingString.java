package com.techgeek.sri;

public class MatchingString {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "ebcg";
        System.out.println(countMatching(s,t));
    }

    private static int countMatching(String s, String t) {
        if (s.equals(t)) {
            return s.length() -2;
        }
        int matching  =0;
        int count = 0;
        int equals = 0;
        char[] swap = s.toCharArray();
        for (int i =0;i<t.length();i++) {
            if (s.charAt(i) == t.charAt(i) ) {
                equals++;
                if (equals >=2) {
                    count++;
                }
            }else {
                int idx = s.indexOf(t.charAt(i));
                if (idx > -1 ) {
                    char tmp = s.charAt(i);
                    swap[i] = s.charAt(idx);
                    swap[idx] = tmp;
                    String nswap = new String(swap);
                    if (nswap.equals(t)) {
                        return s.length();
                    }
                    for (int j = Math.min(idx,i);j<nswap.length();j++) {
                        if (t.charAt(j) == nswap.charAt(j)) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    swap = s.toCharArray();
                    if (matching < count) {
                        matching =count;
                    }
                    count = 0;
                } else {
                    count = 0;
                    equals = 0;
                }
            }
            if (matching < count) {
                matching =count;
            }
        }

        return matching;

    }
}
