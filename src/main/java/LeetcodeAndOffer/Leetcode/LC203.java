package LeetcodeAndOffer.Leetcode;

public class LC203 {

    public ListNode removeElements(ListNode head, int val) {

        // 设置一个虚拟头节点，相当于占位，作为指向头结点的节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 相当于快慢指针
        ListNode pre = dummy;
        ListNode cur = head;

        // 跳出条件
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;

        }
        return dummy.next;


    }

    public ListNode removeElements_second(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }

    static class ListNode {
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


