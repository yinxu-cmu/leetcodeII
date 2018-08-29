package list.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _146_LRU_Cache {

    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * Example:
     *
     * LRUCache cache = new LRUCache( 2 );
     *cache.put(1,1);
     *cache.put(2,2);
     *cache.get(1);       // returns 1
     *cache.put(3,3);    // evicts key 2
     *cache.get(2);       // returns -1 (not found)
     *cache.put(4,4);    // evicts key 1
     *cache.get(1);       // returns -1 (not found)
     *cache.get(3);       // returns 3
     *cache.get(4);       // returns 4
     */

    /**
     *  O(n) 简单解法。 用hashmap 存key value pair 和 single list 存LRU关系。
     */
    class LRUCache {

        int capacity;
        Map<Integer, Integer> map;//(1,1)(3,3)
        List<Integer> list; //head:1->3

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                list.remove(Integer.valueOf(key));
                //append end
                list.add(key);
                return map.get(key);
            }

            return -1;
        }

        public void put(int key, int value) {
            map.put(key, value);
            //find
            if (list.contains(key)) {
                //remove
                list.remove(Integer.valueOf(key));
            }
            //append end
            list.add(key);

            if (list.size() > capacity) {
                //remove head
                int head = list.get(0);//2
                list.remove(0);
                //remove from map;
                map.remove(head);
            }

        }
    }

    /**
     * 高级解法.
     * O(1)的 put, get 时间。
     * 用doubly linked list 代替之前解法的list来存储 LRU 关系， 因为doubly linked list可以实现对node的O(1) add和get。
     * node需要既有key, 又有value, 才能实现O(1).
     */
    class LRUCacheO1 {

        class Node {
            int val;
            int key;
            Node pre;
            Node post;
            public Node() {}
            public Node(int key, int val) {
                this.val = val;
                this.key = key;
            }
        }

        private void addNode(Node node) {
            Node tmp = head.post;
            head.post = node;
            node.pre = head;
            node.post = tmp;
            tmp.pre = node;
        }

        private void removeNode(Node node) {
            Node before = node.pre;
            Node after = node.post;
            before.post = after;
            after.pre = before;
        }

        int capacity;
        int cnt = 0;
        Map<Integer, Node> map;
        Node head, tail;

        public LRUCacheO1(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.post = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node == null) {
                return -1;
            } else {
                //update dblinked list
                removeNode(node);
                addNode(node);

                return node.val;
            }
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                removeNode(node);
                node.val = value;
                addNode(node);
            } else {
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addNode(newNode);
                cnt++;
            }
            if (cnt > capacity) {
                //remove tail
                Node before = tail.pre;
                removeNode(before);
                map.remove(before.key);
                cnt--;
            }
        }
    }
}
