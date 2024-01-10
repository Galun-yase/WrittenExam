package LeetcodeAndOffer.Leetcode;

public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {

            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
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

    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-101, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            while (cur != null && cur.val == pre.val) {
                cur = cur.next;
            }

            if (cur == null) {
                pre.next = cur;
                break;
            }

            pre.next = cur;
            cur = cur.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}
