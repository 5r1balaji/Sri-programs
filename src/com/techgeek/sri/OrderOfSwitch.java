package com.techgeek.sri;

import java.util.*;
/**
         6 6
         1 2
         1 3
         2 5
         3 4
         5 6
         4 6

         Output : 1 3 4 2 5 6
         Order sequence in which the switches should be turned on so that the machine will be working
         6 will be working only when 4 and 5 is turned on, similarly 4 and 5 will be working only when 2 and 3 is turned on
         2 and 3 will be working only when 1 is turned on

         */
public class OrderOfSwitch {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        HashMap<Integer, Queue<Integer>> val = new HashMap<>();
        int m = in.nextInt();
        int n = in.nextInt();
        Integer first,second=0;
        for (int i =0;i<m;i++) {
            in.nextLine();
            Queue<Integer> element = new LinkedList<>();
             first = in.nextInt();
             second = in.nextInt();
            if (val.containsKey(second)) {
                element = val.get(second);
                element.add(first);
            } else {
                element.add(first);
            }
            val.put(second,element);
        }
        print(val,second);
    }

    static void  print(HashMap<Integer, Queue<Integer>> val ,Integer start) {
        String out = "";
        Queue<Integer> order = new LinkedList<>();
        order.add(start);
        while (!order.isEmpty()) {
           Integer k = order.poll();
           if (!out.contains(k+"")){
               out = k+" "+out;
           }
           if (val.containsKey(k)) {
               Queue<Integer> switches = val.get(k);
               while(!switches.isEmpty()) {
                   order.add(switches.poll());
               }
           }
        }
        System.out.println(out);

    }
}
