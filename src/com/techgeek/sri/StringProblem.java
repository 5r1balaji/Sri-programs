package com.techgeek.sri;

import java.util.*;

public class StringProblem {

//    private final  static String s;
//    static{
//        s = "a";
//    }
    public static void main(String[] args) {
     String s = "abcdef";
     List<Integer> as = new LinkedList<>();
     as.add(1);
        System.out.println(as.get(1));
        //System.out.println(getShiftedString(s,10,8));
    }

    static String leftShift(String s, int l) {
        if (l > 0){
            s =  s.substring(l) + s.substring(0, l);
        }
        return s;
    }

    static String rightShift(String s,int r) {
        if (r > 0){
            s =  s.substring(s.length() - r) + s.substring(0, s.length() - r);
        }
        return s;
    }


    public static String getShiftedString(String s, int leftShifts, int rightShifts) {

        if (leftShifts> s.length()-1) {
            leftShifts = leftShifts % (s.length());
        }
        if (rightShifts > s.length()-1) {
            rightShifts = rightShifts % (s.length());
        }
        if (leftShifts == rightShifts) {
            return s;
        }
        if (leftShifts > rightShifts) {
            s = leftShift(s, leftShifts- rightShifts);
        } else {
            s = rightShift(s,rightShifts- leftShifts);
        }

        return s;

    }



}
