package LeetcodeAndOffer.Leetcode;

public class LC143 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node = middleNode(head);
        ListNode head2 = reverseNode(node.next);
        node.next = null;

        ListNode head1 = dummy.next;
        while (head2 != null) {
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;

            head2.next = head1.next;
            head1.next = head2;

            head1 = tmp1;
            head2 = tmp2;
        }
    }

    private ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = reverseNode(head.next);

        head.next.next = head;
        head.next = null;

        return cur;
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

    public void reorderList_2(ListNode head) {
        reorder(head);
    }

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }

        pre.next = null;

        ListNode node = reorder(head.next);
        head.next = cur;
        cur.next = node;
        return head;
    }
}
