package com.techgeek.sri.graphs;



import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

/**
 *  A scientist is testing the choice of interactions made by each bug.
 *  The bug chooses its mate by their gender . There are only 2 genders for the bugs
 *  i.e Male and Female.
 *  Lets consider there are 3 bugs. i.e 1, 2, 3
 *  Given a list of statements { {1,2}, {2,3}, {1,3} }.
 *
 *  Question:
 *  Find out the possibility of the statement to be true.
 *
 *  Condition:
 *  No 2 male or no 2 female bugs can interact with each other.
 *  When an interaction statement is given as 1, 2 it means that 1 and 2 are of different sex.
 *
 *  Result ex:
 *  False because
 *  1 - 2  M -F
 *  2 - 3  F -M
 *  1 - 3  M - M
 *
 *  Solution:
 *  Iterate through N interactions. Create a array of boolean that depicts the visitation of each bug interaction
 *  Create another Character Array of size N bugs in the system where each index i denotes the bug.
 *
 *  At each bug interaction for bugA with bugB. Check for other interactions for bugB from that point.
 *  When a bug is interacting, mark the bugChart with bugA as Male and bugB as Female, based on each interaction and the
 *  existing bugChart mutations update the sex of the bug when not updated.
 *
 *  if at non-visited interaction, the sex of bugA and bugB are same, it means the statement is false and return false.
 *
 *  Time complexity:
 *  O(N) where N is the number of interactions for each bug.
 */
public class BugScientist {
    public static void main(String[] args) {
        int numberOfBugs = 5;
        List<Integer[]> interactions = Arrays.asList(
                new Integer[] { 1, 3 },
                new Integer[] { 2, 5 },
                new Integer[] { 4, 5 },
                new Integer[] { 3, 5 },
                new Integer[] { 4, 2 }
        );
        // M -> F -> M -> F -> M
        // 1 -> 3 -> 5 -> 4 -> 2
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (Integer[] interaction : interactions) {
            int key = interaction[0];
            int value = interaction[1];
            graph.putIfAbsent(key, getEdges(key, value, graph));
            graph.putIfAbsent(value, getEdges(value, key, graph));
        }

        Character[] bugChart = new Character[numberOfBugs + 1];
        boolean isValid = true;
        boolean[][] visited = new boolean[numberOfBugs + 1][ numberOfBugs + 1];
        for (Map.Entry<Integer, Set<Integer>> entry: graph.entrySet()) {
            isValid = verifyBugs(graph, bugChart, entry.getKey(), visited);
            if (!isValid){
                break;
            }
        }

        System.out.println("The statement is "+isValid);

    }

    private static Set<Integer> getEdges(int key, int value, Map<Integer, Set<Integer>> graph) {
        Set<Integer> edges = graph.getOrDefault(key, new HashSet<>());
        edges.add(value);
        return edges;
    }

    private static boolean verifyBugs(Map<Integer, Set<Integer>> graph, Character[] bugChart, int currBug, boolean[][] visited) {
           Set<Integer> bugs = graph.get(currBug);
           for (Integer childBug : bugs) {
               if (!visited[currBug][childBug]) {
                   visited[currBug][childBug] = true;
                   visited[childBug][currBug] = true;
                   setBugSex(bugChart, childBug, currBug);
                   if (bugChart[childBug] == bugChart[currBug]) {
                       return false;
                   }
                   if (!verifyBugs(graph, bugChart, childBug, visited))  {
                       return false;
                   }
               }
           }
       return true;
    }

    private static void setBugSex(Character[] bugChart, Integer childBug, int currBug) {
        if (bugChart[childBug] != null && bugChart[currBug] != null) {
            return;
        }
        if (bugChart[childBug] == null && bugChart[currBug] == null) {
            bugChart[currBug] = 'M';
            bugChart[childBug] = 'F';
        } else if(bugChart[childBug] != null && bugChart[currBug] == null) {
            bugChart[currBug] = complement(bugChart[childBug]);
        } else if(bugChart[childBug] == null && bugChart[currBug] != null) {
            bugChart[childBug] = complement(bugChart[currBug]);
        }
    }

    private static Character complement(Character character) {
        if (character == 'M') {
            return 'F';
        }
        return 'M';
    }

}
