package com.techgeek.sri.dynamicprogramming;

/**
 * Dynamic Programming
 *
 * input = "12345"
 * output :
 * 3
 * explanation
 * 1 -a
 * 12 - l
 * 2- b
 * 3-c
 * 4 -d
 * 5- e
 *
 * 1 , 2345 -> 2 - 345 -> 23 -> 45 - 3
 *
 *
 * if input is empty... then the output is 1
 * if input contains 0... then the output is 0
 *
 * The question is to find the number of ways to decode and not the no. of possible messages....
 * so the ex 121 , the output is 3
 * 1 - 21 -> 1 ,2,1
 * 12,1
 * 1,21
 *
 */
public class PossibleWaysOfDecodingString {

    public static void main(String[] args) {
        String input = "1210";
        int[] mem = new int [input.length()+1];
        int output = decodeString(input,input.length(),mem);
        System.out.println(output);

    }

    private static int decodeString(String input, int length, int[] mem) {
        if (length == 0) {
            return 1;
        }
        int index = input.length() - length;
        if (input.charAt(index) == 0) {
           return 0;
        }
        String currentValue = String.valueOf(input.charAt(index));
        if (isParseable(currentValue)) {
            mem[length] = decodeString(input, length - 1, mem);
            if (index + 1 < input.length() && isParseable(currentValue + input.charAt(index + 1))) {
                mem[length] += decodeString(input, length - 2, mem);
            }
        }
        return mem[length];
    }

    private static boolean isParseable(String character) {
        int val = Integer.parseInt(character);
        return  val > 0 && val < 27;
    }
}
