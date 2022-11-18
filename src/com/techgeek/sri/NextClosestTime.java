package com.techgeek.sri;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a time HH:MM , find the next closest time by reusing the digits in the given Time.
 * Numbers can also be repeated
 * input 19:34
 * output 19:39
 *
 * input
 * 23:59
 * output
 * 22:22
 * The time is after the given time.. so this time happening next day
 */
public class NextClosestTime {

    public static void main(String[] args) {
        String time = "23:50";
        String str[] = time.split(":");
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        Set<Integer> digits = new HashSet<>();
        for (char c : time.toCharArray())
            if (c != ':')
                digits.add(Character.digit(c, 10));
        while (true) {
            minutes = (minutes + 1) % (24 * 60);
            int[] nextTime = {
                    minutes / 60 / 10,
                    minutes / 60 % 10,
                    minutes % 60 / 10,
                    minutes % 60 % 10
            };
            boolean valid = true;
            for (int digit : nextTime)
                if (!digits.contains(digit))
                    valid = false;
            if (valid) {
                System.out.println(String.format("%02d:%02d", minutes / 60, minutes % 60));
                break;
            }

        }

    }
}
