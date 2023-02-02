package com.techgeek.sri;

import java.util.*;

public class Solution {
    public static int checkWinner(ArrayList<ArrayList<String>> codeList,
                           List<String> shoppingCart) {

        boolean res = true;
        int max = 0;
        for (List<String> stringlist : codeList) {
            HashMap<Integer,Integer> map = checkWon(stringlist,shoppingCart);
            Map.Entry<Integer,Integer> s = map.entrySet().iterator().next();

            int k = s.getKey();
            if (k < stringlist.size() || s.getValue() < max) {
                res = false;
                break;
            }
            max = s.getValue();
        }
        return res ? 1 : 0;
        // WRITE YOUR CODE HERE
    }


    public static HashMap<Integer,Integer> checkWon(List<String> codeList,List<String> shoppingCart) {
        HashMap<Integer,Integer> mas = new HashMap<>();
        int i = 0;
        Stack<String> last = new Stack<>();
        int j = 0;
        for(String items : shoppingCart) {
            if (!last.isEmpty()) {
                if (!last.peek().equals(codeList.get(i-1)) && !codeList.get(i-1).equals("anything")) {
                    break;
                }
            }
            if (codeList.get(i).equals(items) || codeList.get(i).equals("anything")) {
                i++;
                last.add(items);
                if (i == codeList.size()) {
                    break;
                }
            } else {
                i = 0;
                last = new Stack<>();
            }
            j++;
        }
        mas.put(i,j);
        return mas;
    }

    public static void main(String[] args) {
        /*ArrayList<String> list0 = new ArrayList<>();
        list0.add("orange");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("apple");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("banana");
        list2.add("anything");
        list2.add("apple");
        ArrayList<ArrayList<String> > codeList =
                new ArrayList<ArrayList<String> >(3);
        codeList.add(list0);
        codeList.add(list1);
        codeList.add(list2);

        ArrayList<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("orange");
        shoppingCart.add("orange");

        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("banana");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        String a ="2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String s[] = a.split(":");
        System.out.println(s[7]);
       System.out.println(checkWinner(codeList,shoppingCart));*/
        System.out.println(getSwapTime("001011"));// 0101001     0010010

    }

    public static int getSwapTime(String color) {
        // Write your code here
        int count0 = 0, count1 = 0;
        for (int i = 0; i < color.length(); i++)
        {
            if (color.charAt(i) == '0')
                count0++;
            else
                count1++;
        }
        return Math.min(count0,count1);
    }
}
