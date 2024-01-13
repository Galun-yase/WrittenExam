package LeetcodeAndOffer.Leetcode;

import LeetCode.ListNode;

import java.util.Arrays;
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

    public ListNode mergeKLists_second(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }

        int mid = lists.length / 2;

        ListNode[] sub1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            sub1[i] = lists[i];
        }

        ListNode[] sub2 = new ListNode[lists.length - mid];
        for (int i = mid; i < lists.length; i++) {
            sub2[i - mid] = lists[i];
        }

        ListNode node1 = mergeKLists_second(sub1);
        ListNode node2 = mergeKLists_second(sub2);

        return mergeTwoLists(node1, node2);
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                cur.next = head2;
                head2 = head2.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }

        if (head1 != null) {
            cur.next = head1;
        }

        if (head2 != null) {
            cur.next = head2;
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

    public ListNode mergeKLists_3(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode node : lists) {
            if (node == null) continue;
            queue.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();

            if (poll.next != null) {
                queue.offer(poll.next);
            }

            pre.next = poll;
            pre = poll;
            poll.next = null;
        }
        return dummy.next;
    }
}
