package com.techgeek.sri.graphs;

import java.util.LinkedList;

public class Graph {
    private int V;   // No. of vertices

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
}
