package LeetcodeAndOffer.Leetcode;

public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        ListNode tmpHead = head;
        int len = 0;
        while (tmpHead != null) {
            tmpHead = tmpHead.next;
            len++;
        }

        k = k % len;
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;

        return newHead;
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

    public ListNode rotateRight_2(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        ListNode dummy = new ListNode(-1, head);

        ListNode pre = dummy;
        int len = 0;
        while (pre.next != null) {
            pre = pre.next;
            len++;
        }

        pre = dummy;
        ListNode cur = head;
        k = k % len;
        if (k == 0) return head;
        int index = len - k;

        while (index > 0) {
            pre = cur;
            cur = cur.next;
            index--;
        }
        pre.next = null;

        ListNode last = cur;
        while (last.next != null) {
            last = last.next;
        }

        last.next = dummy.next;
        dummy.next = cur;

        return dummy.next;
    }
}
