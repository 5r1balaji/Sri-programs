package com.techgeek.sri;

import java.util.*;


/**
 * Question:
 * How many semesters does it take to complete all the courses ?
 * Given there are k courses in a semester and n courses totally.
 * Each course[1] is dependent on course[0] to complete.
 *
 * InDegree gives the dependency degree of a course.
 * At each point whichever course has the lowest dependency weightage is chosen.
 */


class Course {
    int courseNumber;
    Integer priority;

    public Course(int courseNumber, Integer priority) {
        this.courseNumber = courseNumber;
        this.priority = priority;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
public class ParallelCoursesii {
    public static void main(String[] args) {
        int [][] relations= {
                                {12,8},{2,4},{3,7},{6,8},{11,8},{9,4},
                                {9,7},{12,4},{11,4},{6,4},{1,4},{10,7},
                                {10,4},{1,7},{1,8},{2,7},{8,4},{10,8},{12,7},
                                {5,4},{3,4},{11,7},{7,4},{13,4},{9,8},{13,8}
                            };
//        int [][] relations= {
//                {2,1},{3,1},{1,4}
//        };
        int n = 13;
        int k = 9;
        System.out.println(findSemesters(n,relations,k));
    }

    private static int findSemesters(int n, int[][] relations, int k) {
        HashMap<Integer,List<Integer>> dependencies = new HashMap<>();
        int[] indegree = new int[n+1];
        for (int[] relation : relations) {
            int a = relation[0];
            int b = relation[1];
            indegree[b]++;
            List<Integer> list = dependencies.getOrDefault(a, new ArrayList<>());
            list.add(b);
            dependencies.put(a, list);
        }

        Queue<Course> queue = new PriorityQueue<>(Comparator.comparingInt(Course::getPriority).reversed());
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(new Course(i, dependencies.getOrDefault(i, new ArrayList<>()).size()));
            }
        }
        int count = 0;
        int slot = k;
        List<Course> backlog = new ArrayList<>();
        while (!queue.isEmpty()) {
            Course course = queue.poll();
            System.out.print(course.courseNumber+",");
            slot--;
                List<Integer> list = dependencies.getOrDefault(course.courseNumber, new ArrayList<>());
                for (Integer c : list) {
                    indegree[c]--;
                    if (indegree[c] == 0) {
                        backlog.add(new Course(c, dependencies.getOrDefault(c, new ArrayList<>()).size()));
                    }
                }
            if (slot == 0 || queue.isEmpty()) {
                count++;
                slot = k;
                queue.addAll(backlog);
                backlog.clear();
                System.out.println("\n");
            }
        }
        return count;
    }
}
