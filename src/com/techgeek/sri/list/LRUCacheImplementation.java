package com.techgeek.sri.list;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node next;
    Node prev;
}

/**
 * Least Recently used page.
 * When there is a cache hit , that particular page becomes the most frequently asked . So it will be moved  to
 * the front of the queue.
 * the elements in the front will be retained most in the doubly linked list
 * So whenever the get has the value in the queue. it has to be moved to front
 *
 * Similarly the removal of element will happen from the queue, when it has reached the capacity of the queue
 * In that case ,it will again check if the newly added element already exists if that's so , then it will considered
 * most frequently required so it will be added to the front
 *
 * If it does not contain in queue, then last element in the queue i.e tail.prev is removed from the list
 * so as to make space for the new element.
 *
 * In all other cases, a new element is created and pushed to the queue.
 *
 * The get and put operations are of TimeComplexity O(1).
 */
public class LRUCacheImplementation {
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer,Node> map_list;
    int capacity;

    public LRUCacheImplementation(int capacity) {
        map_list = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCacheImplementation cache = new LRUCacheImplementation(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
        cache.put(1,1);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(5));
    }

    private  int get(int key) {
        int result = -1;
        Node temp = map_list.get(key);
        if (temp != null) {
            result = temp.val;
            remove(temp);
            add(temp);
        }
        return result;
    }

    private  void put(int key, int val) {
        Node temp = map_list.get(key);
        if (temp  != null) {
            remove(temp);
            temp.val = val;
            add(temp);
        } else {
            if (map_list.size() == capacity) {
                map_list.remove(tail.prev.key);
                remove(tail.prev);
            }
            temp = new Node();
            temp.key = key;
            temp.val = val;
            map_list.put(key,temp);
            add(temp);
        }
    }

    private void add(Node node) {
        Node node_next = head.next;
        head.next = node;
        node.next = node_next;
        node.prev = head;
        node_next.prev = node;
    }

    private void remove(Node node) {
        Node node_prev = node.prev;
        Node node_next = node.next;

        node_prev.next = node_next;
        node_next.prev = node_prev;

    }
}
