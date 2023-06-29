package LeetcodeAndOffer.Leetcode;


public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode A = headA;
        ListNode B = headB;

        int headA_length = 0;
        int headB_length = 0;
        while (A != null) {
            A = A.next;
            headA_length++;
        }
        while (B != null) {
            B = B.next;
            headB_length++;
        }

        int dis = Math.abs(headA_length - headB_length);
        ListNode fast = headA_length > headB_length ? headA : headB;
        ListNode slow = headA_length <= headB_length ? headA : headB;

        while (dis > 0) {
            fast = fast.next;
            dis--;
        }

        while (fast != null) {
            if (fast == slow) return fast;
            fast = fast.next;
            slow = slow.next;
        }
        return null;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

