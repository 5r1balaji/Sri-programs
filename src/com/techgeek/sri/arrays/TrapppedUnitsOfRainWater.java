package com.techgeek.sri.arrays;

public class TrapppedUnitsOfRainWater {
    public static void main(String[] args) {
        int[] height = {1, 4, 3, 2, 5};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int n = height.length;
        if(n<=2)
            return 0;

        int maxLeft = height[0];
        int maxRight = height[n-1];
        int trappedWater = 0;
        int left = 1;   //Left pointer
        int right = n-2;    //Right pointer
        while(left <= right) {
            if(maxLeft < maxRight) {
                if(height[left] >= maxLeft)
                    maxLeft = height[left];
                else
                    trappedWater += maxLeft-height[left];
                left+=1;
            } else {
                if(height[right]>maxRight)
                    maxRight = height[right];
                else
                    trappedWater += maxRight-height[right];
                right-=1;
            }
        }
        return trappedWater;
    }
}
