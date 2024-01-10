package LeetcodeAndOffer.Leetcode;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        int carryBit = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int res = x + y + carryBit;
            carryBit = res / 10;
            int i = res % 10;

            cur.next = new ListNode(i);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carryBit > 0) {
            cur.next = new ListNode(carryBit);
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

    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return new ListNode(0);
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        int index = 0;
        while (l1 != null && l2 != null) {
            int i = l1.val + l2.val + index;
            pre.next = new ListNode(i % 10);
            index = i / 10;

            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int i = l1.val + index;
            pre.next = new ListNode(i % 10);
            index = i / 10;

            pre = pre.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int i = l2.val + index;
            pre.next = new ListNode(i % 10);
            index = i / 10;

            pre = pre.next;
            l2 = l2.next;
        }

        if (index > 0) {
            pre.next = new ListNode(index);
        }

        return dummy.next;
    }
}
