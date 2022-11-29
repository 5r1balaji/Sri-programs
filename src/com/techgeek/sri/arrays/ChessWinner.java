package com.techgeek.sri.arrays;

import java.util.*;

public class ChessWinner {
    public static void main(String[] args) {
        System.out.println("The winner is "+ getWinner(Arrays.asList(3,2,1,4),3));
    }

    private static int getWinner(List<Integer> potential, int k) {
        Map<Integer, Integer> potentialMap = new HashMap<>();
        int[] winHistory = new int [potential.size() + 1];
        int playerName = 1, winningPotentialValue, winner = 1;
        for (int playerPotential : potential) {
            potentialMap.put(playerPotential, playerName++);
        }
        Deque<Integer> pot = new LinkedList<>(potential);
        while(!pot.isEmpty() && winHistory[winner] != k) {
            int player1 = pot.pollFirst();
            int player2 = pot.pollFirst();
            winningPotentialValue = getWhoWon(player1, player2);
            if (winningPotentialValue == player1) {
                pot.addLast(player2);
            } else {
                pot.addLast(player1);
            }
            pot.addFirst(winningPotentialValue);
            winner = potentialMap.get(winningPotentialValue);
            ++winHistory[winner];
        }
        return winner;
    }

    private static int getWhoWon(int player1, int player2) {
        return Math.max(player1, player2);
    }
}
