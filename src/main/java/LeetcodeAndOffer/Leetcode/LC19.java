package LeetcodeAndOffer.Leetcode;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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

    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);

        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode tmp = slow.next;
        slow.next = tmp.next;
        tmp.next = null;

        return dummy.next;
    }
}



