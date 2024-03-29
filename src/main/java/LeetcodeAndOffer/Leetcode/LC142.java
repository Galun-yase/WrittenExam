package LeetcodeAndOffer.Leetcode;

public class LC142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 快慢指针可以相等，则代表存在环
        // 存在环时需要指定两个指针分别在起始处和相遇处同速率移动
        // 根据 x+y=[x+y+n(y+z)]/2 即 x=n(y+z)-y 判断再次第一次相遇时必定是在环的入口处

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {

                ListNode cur = fast;
                ListNode pre = head;
                while (cur != pre) {
                    cur = cur.next;
                    pre = pre.next;
                }
                return cur;
            }
        }
        return null;
    }

    public ListNode detectCycle_second(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) return null;

            fast = fast.next.next;
            slow = slow.next;

        } while (fast != slow);

        ListNode nodeX = head;
        ListNode nodeY = fast;

        while (nodeX != nodeY) {
            nodeX = nodeX.next;
            nodeY = nodeY.next;
        }

        return nodeX;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle_3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        slow = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
