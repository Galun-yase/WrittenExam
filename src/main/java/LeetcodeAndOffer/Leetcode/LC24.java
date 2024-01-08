package LeetcodeAndOffer.Leetcode;

public class LC24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmpNode = swapPairs(head.next.next);

        head.next.next = head;

        ListNode res = head.next;
        head.next = tmpNode;
        return res;
    }

    //  Definition for singly-linked list.
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

    public ListNode swapPairs_2(ListNode head) {
        ListNode pNode = new ListNode(-1, head);

        ListNode p = pNode;
        while (head != null && head.next != null) {
            ListNode tmp = head.next;
            p.next = tmp;
            head.next = tmp.next;
            tmp.next = head;

            p = head;
            head = head.next;
        }
        return pNode.next;
    }
}

