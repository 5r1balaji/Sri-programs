package com.techgeek.sri;

/**
 * There are n dominoes in a line, and we place each domino vertically upright.
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 *
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 *
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the
 * balance of the forces.
 *
 * For the purposes of this question, we will consider that a falling domino
 * expends no additional force to a falling or already fallen domino.
 *
 * You are given a string dominoes representing the initial state where:
 *
 * dominoes[i] = 'L', if the ith domino has been pushed to the left,
 * dominoes[i] = 'R', if the ith domino has been pushed to the right, and
 * dominoes[i] = '.', if the ith domino has not been pushed.
 * Return a string representing the final state.
 *
 *
 *
 * Example 1:
 *
 * Input: dominoes = "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 *
 * Solution :
 * At each '.' the index of the domino is going to be affected by the force from any direction we are traversing
 * We traverse from left to right by keeping left domino as a dormant force
 * and then we traverse from right to left keeping right as a dormant force.
 * So for each traversal , the vertical dominoes will be updated by the force-1 indicating that the domino is affected
 * by the R or L force.
 * When there are equal forces on both side , then the dominoes will remain still
 * this can be done by subtracting the forces on each side , if the value is +ve then that is overruled by right domino
 * -ve indicates left domino
 * 0 indicates forces are equal.
 *
 * At each index the force can never be negative because at the very least the force can be dormant i.e 0
 * When we subtract the force , we can infer which domino won at that place.
 *
 * Time Complexity :
 * O(N) + O(N) = 2 O(N)
 */
public class PushDominoes {
    public static void main(String[] args) {
        String dominoes = ".L.R...L.R..";
        //RR...L
        char[] chars = dominoes.toCharArray();
        int[] forces = new int[chars.length];
        int force = 0;

        int N = chars.length;
        for (int i = 0;i < N ;i++) {
            if (chars[i] == 'R') {
                force = N;
            } else if (chars[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1 , 0);
            }
            forces[i] = force;
        }
        force = 0;
        for (int i = N - 1;i > -1 ;i--) {
            if (chars[i] == 'L') {
                force = N;
            } else if (chars[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (forces[i] < 0) {
                builder.append('L');
            } else if (forces[i] > 0) {
                builder.append('R');
            } else {
                builder.append('.');
            }
        }
        System.out.println(builder.toString());
    }
}
