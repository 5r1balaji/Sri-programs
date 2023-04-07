package com.techgeek.sri.graphs;

import java.util.*;

public class BiPartition {
    public static void main(String[] args) {
        BiPartition bi = new BiPartition();
        int[][] dislikes = {
                {4,7},
                {4,8},
                {5,6},
                {1,6},
                {3,7},
                {2,5},
                {5,8},
                {1,2},
                {4,9},
                {6,10},
                {8,10},
                {3,6},
                {2,10},
                {9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}
        };
        System.out.println(bi.possibleBipartition(10, dislikes));
    }

    public boolean bfs(int source, Map<Integer, List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        color[source] = 0; // Start with marking source as `RED`.

        while (!q.isEmpty()) {
            int node = q.poll();
            if (!adj.containsKey(node))
                continue;
            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == color[node])
                    return false;
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1); // 0 stands for red and 1 stands for blue.
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                // For each pending component, run BFS.
                if (!bfs(i, adj, color))
                    // Return false, if there is conflict in the component.
                    return false;
            }
        }
        return true;
    }
}
