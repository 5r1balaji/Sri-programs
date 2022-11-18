package com.techgeek.sri.graphs;

import java.util.*;

public class DepthFirstSearch {
    public static void main(String args[] ) throws Exception {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        dfs(2,g);
    }

    private static void dfs(int i, Graph g) {
        boolean [] visited = new boolean[4];
        dfsUtil(i,visited,g);
    }

    private static void dfsUtil(int i, boolean[] visited, Graph g) {
        System.out.print(i);
        visited[i] = true;
        Iterator<Integer> iterator = g.getAdj()[i].iterator();
        while(iterator.hasNext()) {
            int s = iterator.next();
            if (!visited[s]) {
                dfsUtil(s,visited,g);
            }
        }
    }


}
