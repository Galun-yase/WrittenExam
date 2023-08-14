package LeetcodeAndOffer.Leetcode;

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {

            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;

                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates_recursion(ListNode head) {
        if (head == null || head.next == null) return head;

        if (head.val != head.next.val) {
            ListNode newNode = deleteDuplicates_recursion(head.next);
            head.next = newNode;
            return head;
        } else {
            int val = head.val;

            while (head.next != null && head.next.val == val) {
                head = head.next;
            }
            return deleteDuplicates_recursion(head.next);
        }
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
}
