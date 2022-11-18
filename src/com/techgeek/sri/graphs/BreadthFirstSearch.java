package com.techgeek.sri.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**            1 -- 4  ---
 *           /             \
 *         /               5
 *      0  -- 3  --- 2    /
 *             \        /
 *              \     /
 *               6
 *      Its nothing but level order traversal of a tree.
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1,4);
        g.addEdge(0, 3);
        g.addEdge(3,2);
        g.addEdge(3,6);
        g.addEdge(6,5);
        g.addEdge(4,5);
        //g1.addEdge(3,5);
       // g1.addEdge(3,5);
        bfs(0,g);
    }

    private static void bfs(int i, Graph g1) {
        boolean [] visited = new boolean[7];
        Queue<Integer> nextToVisit = new LinkedList<>();
        nextToVisit.add(i);

        while(!nextToVisit.isEmpty()) {
            int k = nextToVisit.poll();
            if (!visited[k]) {
                System.out.print(k);
            }
            visited[k] = true;
            g1.getAdj()[k].stream().filter(a -> !visited[a] ).forEach(nextToVisit::add);
        }
    }
}
