package com.wishhust.arithmetic.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Leetcode146 {

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LRUCache {

    Queue<Integer> keyQueue = new LinkedList<>();
    Map<Integer, Integer> kvMap = new HashMap<>();
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        if (kvMap.containsKey(key)) {
            value = kvMap.get(key);
            keyQueue.remove(key);
            keyQueue.add(key);
        }
        return value;
    }

    public void put(int key, int value) {
        if (kvMap.containsKey(key)) {
            keyQueue.remove(key);
        }
        if (keyQueue.size() >= this.capacity) {
            Integer poll = keyQueue.poll();
            kvMap.remove(poll);
        }
        kvMap.put(key, value);
        keyQueue.add(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);                        // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));      // 返回  4

    }
}


/**
 * LRU 双向链表+map实现
 *
 *                          map (k, node)
 *                           |
 *                   ++++++++++++++++
 *                   +              +
 *                   +              +
 *  head             +              +            tail
 *  ++++           +++++          +++++          ++++
 *  +  + ------->  + k + -------> + k + -------> +  +
 *  +  + <-------  + v + <------- + v + <------- +  +
 *  ++++           +++++          +++++          ++++
 */


class LRUCache2 {

    private Map<Integer, Node> keyMap = new HashMap<>();
    private DoubleList doubleList = new DoubleList(); // 双向链表
    private int capacity = 0;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        int result = -1;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            result = node.value;
            doubleList.delNode(node);
            doubleList.addLast(node);
        }

        return result;
    }

    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            doubleList.delNode(node);
        }

        if (doubleList.size >= this.capacity) {
            Node node = doubleList.delFirst();
            keyMap.remove(node.key);
        }
        Node newNode = new Node(key, value);
        keyMap.put(key, newNode);
        doubleList.addLast(newNode);
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);                        // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));      // 返回  4
    }
}


