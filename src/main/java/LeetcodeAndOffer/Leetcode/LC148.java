package LeetcodeAndOffer.Leetcode;

public class LC148 {
    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummy = new ListNode(-1, head);

        for (int subLength = 1; subLength < length; subLength *= 2) {
            ListNode pre = dummy;
            ListNode cur = dummy.next;

            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }

                ListNode merged = mergeTwoLists(head1, head2);
                pre.next = merged;

                while (pre.next != null) {
                    pre = pre.next;
                }

                cur = next;
            }
        }
        return dummy.next;
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

    public class ListNode {
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
