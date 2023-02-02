package com.techgeek.sri.arrays;

import java.util.Arrays;

public class ParkingDilemma {

    public static void main(String[] args) {
        int[] cars = {17,1,6,15,16,5};
        System.out.println(parkingDilemma(cars, 4));
    }
    public static int parkingDilemma(int[] cars, int k) {
        // write your code here

        Arrays.sort(cars);// 1,5,6,15,16,17
        int min = Integer.MAX_VALUE;      //i <= 3
        for (int i = 0; i <= cars.length - k; i++) {
            int temp = cars[i + k - 1] - cars[i] + 1;// 10
            if (temp < min) {
                min = temp;// 9
            }
        }
        return min;
    }
}
