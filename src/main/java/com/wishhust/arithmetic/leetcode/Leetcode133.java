package com.wishhust.arithmetic.leetcode;

import java.util.*;

/**
 * 克隆图
 *
 * 使用广度优先搜索，由于需要创建新创建节点，故用了一个map存放创建的节点，
 * 避免重复创建节点。
 *
 *
 */

class Node133 {
    public int val;
    public List<Node133> neighbors;

    public Node133() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node133(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node133(int _val, ArrayList<Node133> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class Leetcode133 {
    public Node133 cloneGraph(Node133 node) {

        Queue<Node133> queue = new ArrayDeque<>();
        queue.add(node);
        Node133 res = null;   //最终返回值
        Node133 temp = null;  //临时节点
        // 存放创建的节点
        HashMap<Integer, Node133> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Node133 poll = queue.poll();
            // 若已经创建，则直接取出
            if (map.containsKey(poll.val)) {
                temp = map.get(poll.val);
            } else {
                temp = new Node133(poll.val);
            }
            if (res == null) {
                res = temp;
                map.put(poll.val, temp);
            }
            for (Node133 nodeTemp : poll.neighbors) {
                if (map.containsKey(nodeTemp.val)) {
                    temp.neighbors.add(map.get(nodeTemp.val));
                } else {
                    Node133 newNode = new Node133(nodeTemp.val);
                    temp.neighbors.add(newNode);
                    map.put(newNode.val, newNode);
                }

            }
            queue.addAll(poll.neighbors);

        }
        return res;

    }


}
