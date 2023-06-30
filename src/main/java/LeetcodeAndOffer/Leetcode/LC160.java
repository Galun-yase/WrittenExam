package LeetcodeAndOffer.Leetcode;


public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1、优化版本，数学思想，公倍数
        if (headA == null || headB == null) return null;

        ListNode pointA = headA;
        ListNode pointB = headB;

        while (pointA != pointB) {
            pointA = pointA == null ? headB : pointA.next;
            pointB = pointB == null ? headA : pointB.next;
        }
        return pointA;

        // 2、计算长度
//        ListNode A = headA;
//        ListNode B = headB;
//
//        int headA_length = 0;
//        int headB_length = 0;
//        while (A != null) {
//            A = A.next;
//            headA_length++;
//        }
//        while (B != null) {
//            B = B.next;
//            headB_length++;
//        }
//
//        int dis = Math.abs(headA_length - headB_length);
//        ListNode fast = headA_length > headB_length ? headA : headB;
//        ListNode slow = headA_length <= headB_length ? headA : headB;
//
//        while (dis > 0) {
//            fast = fast.next;
//            dis--;
//        }
//
//        while (fast != null) {
//            if (fast == slow) return fast;
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return null;

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

