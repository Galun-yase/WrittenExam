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

    public ListNode getIntersectionNode_second(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != pointB) {
            // 注意pointA == null而非pointA.next == null,否则会发生无限循环
            pointA = pointA == null ? headB : pointA.next;
            pointB = pointB == null ? headA : pointB.next;

        }
        return pointA;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}

