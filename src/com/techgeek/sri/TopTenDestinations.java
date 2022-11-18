package com.techgeek.sri;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  Find the destination with Maximum counts and print all those destinations maximum 10
 *                  "2020-01-12,MAS,BLR",
 *                 "2020-01-12,MAS,CBE",
 *                 "2020-01-12,MAS,KET",
 *                 "2020-01-12,MAS,KOCH",
 *                 "2020-01-12,MAS,KOCH",
 *                 "2020-01-12,MAS,sdf",
 *                 "2020-01-12,MAS,rrr",
 *                 "2020-01-12,MAS,ttty",
 *                 "2020-01-12,MAS,rrr",
 *                 "2020-01-12,MAS,test",
 *                 "2020-01-12,MAS,HYB",
 *       In the above case destination rrr and KOCH occur twice
 *
 */
public class TopTenDestinations {

    public static void main(String[] args) {
        String a [] =  {
                "2020-01-12,MAS,BLR",
                "2020-01-12,MAS,CBE",
                "2020-01-12,MAS,KET",
                "2020-01-12,MAS,KOCH",
                "2020-01-12,MAS,KOCH",
                "2020-01-12,MAS,sdf",
                "2020-01-12,MAS,rrr",
                "2020-01-12,MAS,ttty",
                "2020-01-12,MAS,rrr",
                "2020-01-12,MAS,test",
                "2020-01-12,MAS,HYB",
        };

        printTop(a);
    }

    static void printTop(String[] arr) {
        int maxSum = 0;
        HashMap<String,Integer> counts = new HashMap<>();
        HashMap<Integer, List<String>> topTen = new HashMap<>();
        for (int i =0;i<arr.length;i++) {
            String data[] = arr[i].split(",");
            if (counts.containsKey(data[2])) {
                int k = counts.get(data[2]);
                counts.put(data[2],k++);
                if (k > maxSum) {
                    maxSum = k;
                }
                if (topTen.containsKey(k)) {
                    List<String> list = topTen.get(k);
                    list.add(data[2]);
                    topTen.put(k,list);
                } else {
                    List<String> top = new ArrayList<>();
                    top.add(data[2]);
                    topTen.put(k,top);
                }

            } else {
                counts.put(data[2],1);
                if (maxSum < 1) {
                    maxSum =1;
                }
                if (topTen.containsKey(1)) {
                    List<String> list = topTen.get(1);
                    list.add(data[2]);
                    topTen.put(1,list);
                } else {
                    List<String> top = new ArrayList<>();
                    top.add(data[2]);
                    topTen.put(1,top);
                }
            }
        }


        List<String> s = topTen.get(maxSum);
        int i = 0;
        while(i< s.size() && i<10) {
            System.out.println(s.get(i));
            i++;
        }


    }



}
