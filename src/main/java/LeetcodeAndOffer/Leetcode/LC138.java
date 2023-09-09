package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;

public class LC138 {
    public Node copyRandomList(Node head) {
        Node cur = head;

        HashMap<Node, Node> hashMap = new HashMap<>();
        while (cur != null) {
            Node newNode = new Node(cur.val);
            hashMap.put(cur, newNode);

            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node curNewNode = hashMap.get(cur);

            Node next = cur.next;
            Node newNextnode = hashMap.get(next);

            Node random = cur.random;
            Node randomNextnode = hashMap.get(random);

            curNewNode.next = newNextnode;
            curNewNode.random = randomNextnode;

            cur = cur.next;
        }

        return hashMap.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
