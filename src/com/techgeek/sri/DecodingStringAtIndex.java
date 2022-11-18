package com.techgeek.sri;

public class DecodingStringAtIndex {

    public static void main(String[] args) {
        String s = "a2345678999999999999999";
        System.out.println(decodeAtIndex(s,5));
    }
    public static String decodeAtIndex(String s, int k) {

        long size = 0;
        String number = "";
        for (Character c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                if (!number.isEmpty()) {
                    size = size * (Long.parseLong(number));
                    number = "";
                }
                size++;
            } else {
                number += c;
            }
        }

        if (!number.isEmpty()) {
            size = size * Long.parseLong(number);
        }
        number = "";
        long t = k;
        for (int i = s.length() - 1; i >= 0; i--) {
            Character c = s.charAt(i);
            t = t % size;
            if ((k == 0 || k == size)
                    && Character.isLetter(c)) {
                return Character.toString(c);
            }

            if (Character.isDigit(c)) {
                number += c;
                if (i - 1 >= 0 && Character.isLetter(s.charAt(i-1)) ) {
                    size = size / (Long.parseLong(number));
                    number = "";
                }

            } else {
                size--;
            }
        }

        return null;
    }
}
