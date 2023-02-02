package com.techgeek.sri;

import java.util.*;

/**
 *  Given a list of offices and their work timings and dependencies
 *    Office   Start(hrs)   End(hrs)   Dependencies
 *      1       13            15         []
 *      2       9             19         []
 *      3       9             11         []
 *      4       11            13         [2,3]
 *  Dependencies mean that work at one Office cannot be completed before visiting its dependencies
 *  Find the number of offices that can be visited in the given time .
 *  Or Print the offices that can be visited in the given interval .(in hrs)
 *  It takes 1 hr in each office
 *
 * input is the work hours of a on employee i.e he starts work 10 am and finishes at 18pm.
 *
 *  Ex:
 *  input 10 18
 *
 *  output
 *  3 4 2 1
 *
 */
public class AdministrativeHell {
    public static void main(String[] args) {
        Office of1 = new Office();
        of1.startTime = 13;
        of1.endTime = 15;
        of1.name = "1";

        Office of2 = new Office();
        of2.startTime = 9;
        of2.endTime = 15;
        of2.name = "2";

        Office of3 = new Office();
        of3.startTime = 8;
        of3.endTime = 10;
        of3.name = "3";
        of3.offices.add(of2);

        Office of4  = new Office();
        of4.startTime = 11;
        of4.endTime = 13;
        of4.name = "4";
        of4.offices = Arrays.asList(of2,of3);

        HashSet<String> visited = new HashSet<>();
        PriorityQueue<Office> offices = new PriorityQueue<>(new ComplexComparator(new StartTimeComparator(),new EndTimeComparator()));
        offices.add(of1);
        offices.add(of4);
        printOrder(offices,visited,10,18);
    }

    private static int printOrder(PriorityQueue<Office> off,HashSet<String> visited,int current,int endTime) {
         while(!off.isEmpty()) {
             Office of = off.poll();
             if (isEligible(of,current,endTime) && !visited.contains(of.name) ) {
                 if (of.offices.isEmpty()) {
                     current = Math.max(current, of.startTime);
                     System.out.print(of.name+",");
                     current++;
                     visited.add(of.name);
                 } else {
                     PriorityQueue<Office> offices = new PriorityQueue<>(new ComplexComparator(new StartTimeComparator(),new EndTimeComparator()));
                     offices.addAll(of.offices);
                     current = printOrder(offices,visited,current,endTime);
                     if ( isEligible(of,current,endTime) && isChildOfficeVisited(of.offices,visited)) {
                         System.out.print(of.name+",");
                         visited.add(of.name);
                     }
                 }
             }

         }
        return current;
    }

    private static boolean isChildOfficeVisited(List<Office> offices, HashSet<String> visited) {
        for (Office off: offices) {
            if (!visited.contains(off.name)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEligible(Office of, int currentTime, int endTime) {
        return  currentTime <= of.endTime && currentTime <= endTime ;
    }


}


class Office {
    String name;
    int startTime;
    int endTime;
    List<Office> offices = new ArrayList<>();

    @Override
    public String toString() {
        return "Office{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", offices=" + offices +
                '}';
    }
}


class ComplexComparator implements Comparator<Office> {

    private Comparator<Office> comparatorOne;
    private Comparator<Office> comparatorTwo;

    public ComplexComparator(Comparator<Office> one,
                             Comparator<Office> another) {
        this.comparatorOne = one;
        this.comparatorTwo = another;
    }

    @Override
    public int compare(Office one, Office another) {
        // make a first comparison using comparator one
        int comparisonByOne = comparatorOne.compare(one, another);

        // check if it was 0 (items equal in that attribute)
        if (comparisonByOne == 0) {
            // if yes, return the result of the next comparison
            return comparatorTwo.compare(one, another);
        } else {
            // otherwise return the result of the first comparison
            return comparisonByOne;
        }
    }
}


class StartTimeComparator implements Comparator<Office>{
    public int compare(Office of1,Office of2) {
        return Integer.compare(of1.startTime,of2.startTime);
    }
}
class EndTimeComparator implements Comparator<Office> {

    @Override
    public int compare(Office of1, Office of2) {
        return Integer.compare(of1.endTime - of1.startTime,of2.endTime - of2.startTime);
    }
}

