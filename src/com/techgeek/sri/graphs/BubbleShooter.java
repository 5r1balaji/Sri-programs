package com.techgeek.sri.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [ w  r  g  y
 *   r  r  g  w
 *   y  w  w  w ]
 *        ^w
 */
 class Vertices {
    private int i ;
    private int j;

    public Vertices(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
public class BubbleShooter {
    public static void main(String[] args) {
        char arr [][] = {
                         {'w','r','g','y'},
                         {'r','r','g','w'},
                         {'w','y','w','w'},
                         {'y','y','y','w'}
                       };
        int i = 2,j = 2;
        while (arr[i][j] == ' ' && i > 0) {
            i--;
        }
        if (i < 0) {
            System.out.println("No bubbles to shoot");
            return;
        }
        Vertices  start = new Vertices(i,j);
        Queue<Vertices> bubbles = new LinkedList<>();
        bubbles.add(start);
        shootbubble(bubbles,arr,'w');
        printBubble(arr);
    }

    private static void printBubble(char[][] arr) {
        for (int i = 0 ;i<4 ;i++) {
            for (int j = 0;j<4;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    private static void shootbubble( Queue<Vertices> bubbles, char[][] arr,char target) {
        while(!bubbles.isEmpty()) {
            Vertices start = bubbles.poll();
            int i = start.getI(),j = start.getJ();
            if (arr[i][j] == target) {
                arr[i][j] = ' ';
                addAdjacents(bubbles,i,j,target,arr);
            }

        }

    }

    private static void addAdjacents(Queue<Vertices> bubbles, int i, int j, char target,char[][] arr) {
        if (j-1 >= 0 && checkBubble(arr,i,j-1,target)) {
            bubbles.add(new Vertices(i,j-1));
        }
        if (i-1 >= 0  && checkBubble(arr,i-1,j,target)) {
            bubbles.add(new Vertices(i-1,j));
        }
        if (j+1 <= 3 &&  checkBubble(arr,i,j+1,target)) {
            bubbles.add(new Vertices(i,j+1));
        }
        if (i+1 <=3 && checkBubble(arr,i+1,j,target)) {
            bubbles.add(new Vertices(i+1,j));
        }
    }

    private static boolean checkBubble(char[][] arr, int i, int j,char target) {
        return arr[i][j] != ' ' && arr[i][j] == target;
    }


}
