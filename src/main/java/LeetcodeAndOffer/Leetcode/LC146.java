package LeetcodeAndOffer.Leetcode;

import javafx.scene.chart.ValueAxis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC146 {
    class LRUCache {

        int capacity;
        int length;
        // 存储当前键及对应的节点和值
        // key:[node,value]
        Map<Integer, Object[]> maps;

        DULNode head;
        DULNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.length = 0;
            maps = new HashMap<>();

            head = new DULNode(-1);
            tail = new DULNode(-1);

            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (maps.containsKey(key)) {
                DULNode node = (DULNode) maps.get(key)[0];

                DULNode preNode = node.pre;
                DULNode nextNode = node.next;

                preNode.next = nextNode;
                nextNode.pre = preNode;

                DULNode tmp = head.next;

                node.next = tmp;
                tmp.pre = node;
                head.next = node;
                node.pre = head;

                return (Integer) maps.get(key)[1];
            } else {
                return -1;
            }

        }

        public void put(int key, int value) {
            if (maps.containsKey(key)) {
                DULNode node = (DULNode) maps.get(key)[0];

                DULNode preNode = node.pre;
                DULNode nextNode = node.next;

                preNode.next = nextNode;
                nextNode.pre = preNode;

                DULNode tmp = head.next;

                node.next = tmp;
                tmp.pre = node;
                head.next = node;
                node.pre = head;

                maps.put(key, new Object[]{node, value});
            } else {
                if (length == capacity) {
                    DULNode delNode = tail.pre;
                    DULNode preDelNode = tail.pre.pre;

                    preDelNode.next = tail;
                    tail.pre = preDelNode;

                    length--;
                    maps.remove(delNode.val);
                }
                // 当LRU满时，需要删除最后一个节点并删除map中的kv，故需通过最后一个节点获取到map的key，故node.val=key
                DULNode node = new DULNode(key);

                DULNode tmp = head.next;
                head.next = node;
                node.pre = head;
                node.next = tmp;
                tmp.pre = node;

                length++;
                maps.put(key, new Object[]{node, value});
            }
        }
    }

    class DULNode {
        DULNode pre;
        DULNode next;
        int val;

        DULNode(int val) {
            this.val = val;
        }
    }

    class LRUCache_extend extends LinkedHashMap<Integer, Integer> {

        int capacity;

        public LRUCache_extend(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > this.capacity;
        }
    }

    static class LRUCache_2 {

        class LRUNode {
            int key;
            int value;
            LRUNode pre;
            LRUNode next;

            LRUNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

        }

        int cap;
        HashMap<Integer, LRUNode> map;
        LRUNode head;
        LRUNode tail;

        public LRUCache_2(int capacity) {
            cap = capacity;
            map = new HashMap<>();
            head = new LRUNode(-1, -1);
            tail = new LRUNode(-1, -1);

            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;

            LRUNode lruNode = map.get(key);

            LRUNode pre = lruNode.pre;
            LRUNode next = lruNode.next;

            pre.next = next;
            next.pre = pre;

            lruNode.pre = null;
            lruNode.next = null;

            LRUNode tailPre = tail.pre;
            tailPre.next = lruNode;
            lruNode.pre = tailPre;

            lruNode.next = tail;
            tail.pre = lruNode;

            return lruNode.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                get(key);
                tail.pre.value = value;
            } else {
                if (map.size() == cap) {
                    LRUNode lruNode = head.next;
                    head.next = lruNode.next;
                    lruNode.next.pre = head;

                    lruNode.pre = null;
                    lruNode.next = null;

                    map.remove(lruNode.key);

                    put(key, value);
                } else {
                    LRUNode lruNode = new LRUNode(key, value);
                    LRUNode taiPre = tail.pre;
                    taiPre.next = lruNode;
                    lruNode.pre = taiPre;

                    tail.pre = lruNode;
                    lruNode.next = tail;

                    map.put(key, lruNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        LRUCache_2 lruCache2 = new LRUCache_2(2);
        lruCache2.put(1, 1);
        lruCache2.put(2, 2);
        lruCache2.get(1);
        lruCache2.put(3, 3);
        lruCache2.get(2);

    }
}
