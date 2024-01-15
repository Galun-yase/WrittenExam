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

    public ListNode sortList_2(ListNode head) {
        if (head == null || head.next == null) return head;


        ListNode pre = new ListNode(-1, head);

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        ListNode h1 = sortList_2(head);
        ListNode h2 = sortList_2(slow);
        return merge(h1, h2);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (left != null && right != null) {
            ListNode node = new ListNode();

            if (left.val <= right.val) {
                node.val = left.val;
                left = left.next;
            } else {
                node.val = right.val;
                right = right.next;
            }

            pre.next = node;
            pre = pre.next;
        }

        if (left != null) {
            pre.next = left;
        }
        if (right != null) {
            pre.next = right;
        }

        return dummy.next;
    }
}
