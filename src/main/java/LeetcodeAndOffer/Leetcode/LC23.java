package LeetcodeAndOffer.Leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));

        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();

            tail.next = node;
            tail = node;

            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
