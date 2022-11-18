package com.techgeek.sri.arrays;


/**
 * Solution:
 * The idea is to find the maximum jump from that index. Since its given that you can always reach the end
 * atleast 1 jump is always possible.
 * So till the maximum jump at one point , you can always consider only 1 jump happens .
 * While we traverse till the maximum jump point we identify what is next best highest jump we can make from that point
 * that will be updated as farthest.
 * Maxmimum point is CurrentJump everytime that index is traversed we update till what index shud we traverse
 *
 * Also we never traverse the end point or else jump will be updated uncessarily.
 *
 * Time Complexity:
 * O(N)
 */
public class JumpGameII {
    public static void main(String[] args) {
        int[] nums ={0,2,3,0,2,0,5};
        int jumps = 0, maximumJumpPoint = 0, farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) { // never traverse the last
                                            // index as there wont be any jump happening here
            farthest = Math.max(i + nums[i] , farthest); // updating the farthest jump at each index i
            if (i == maximumJumpPoint) { // Traverse till the maxJump point and update the next jump point index.
                jumps++;
                maximumJumpPoint = farthest;
            }
        }
        System.out.println(jumps);
    }

}
