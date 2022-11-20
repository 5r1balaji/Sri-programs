package com.techgeek.sri;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "aabcfdbdce";
        int[] arr = new int[256];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)] == 1){
                System.out.println(str.charAt(i));
                break;
            }
        }
    }
}
