package LeetcodeAndOffer.Leetcode;

public class LC92 {


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            cur = cur.next;
        }

        for (int i = 0; i < right - left; i++) {
            ListNode tmp = cur.next;

            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;

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

    public ListNode reverseBetween_2(ListNode head, int left, int right) {
        if (head == null) return head;

        if (1 != left) {
            head.next = reverseBetween_2(head.next, left - 1, right - 1);
            return head;
        }

        int index = left;

        ListNode cur = head;
        ListNode next = cur.next;
        while (index != right) {
            ListNode pre = cur;
            cur = next;
            next = next.next;
            cur.next = pre;

            index++;
        }
        head.next = next;

        return cur;
    }
}
