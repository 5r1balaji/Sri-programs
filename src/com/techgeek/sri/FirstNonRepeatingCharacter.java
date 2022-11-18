package com.techgeek.sri;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "aabcdbdce";
        int arr[] = new int[256];
        String res ="";
        for (int i =0;i< str.length();i++) {
            arr[str.charAt(i)]++;
            if (arr[str.charAt(i)] == 1) {
                res += str.charAt(i);
            } else {
                res = res.replace(str.charAt(i),' ');
            }
        }
        System.out.println(res.trim());
    }
}
