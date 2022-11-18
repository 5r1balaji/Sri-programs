package com.techgeek.sri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneKeypadCombinations {
    private static Character[][] numberToCharMap ;
    public static void main(String[] args) {
        String abc = "23";
        List<String> res = new ArrayList<>();
        int [] numbers = new int[abc.length()];
        for (int i = 0;i<abc.length();i++) {
            numbers[i] = Integer.parseInt(abc.charAt(i)+"");
        }
        generateNumberToCharMap();
      //getCombinations(0,numbers,res);
        for (String re : res) {
            System.out.println(re);
        }
    }
    private static void generateNumberToCharMap()
    {
        numberToCharMap = new Character[10][5];
        numberToCharMap[0] = new Character[]{'\0'};
        numberToCharMap[1] = new Character[]{'\0'};
        numberToCharMap[2] = new Character[]{'a','b','c'};
        numberToCharMap[3] = new Character[]{'d','e','f'};
        numberToCharMap[4] = new Character[]{'g','h','i'};
        numberToCharMap[5] = new Character[]{'j','k','l'};
        numberToCharMap[6] = new Character[]{'m','n','o'};
        numberToCharMap[7] = new Character[]{'p','q','r','s'};
        numberToCharMap[8] = new Character[]{'t','u','v'};
        numberToCharMap[9] = new Character[]{'w','x','y','z'};
    }
    private static void getCombinations(int i, String abc,String[] res) {

    }


}
