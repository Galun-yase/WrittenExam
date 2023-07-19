package LeetcodeAndOffer.Leetcode;

public class LC206 {

    public ListNode reverseList(ListNode head) {
        // 先判断终止条件,反转后为本身
        if (head == null || head.next == null) return head;

        // 递归反转后面的节点，并处理当前节点
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        // cur为当前头节点
        return cur;
    }

    public ListNode reverseList_second(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = reverseList_second(head.next);

        head.next.next = head;
        head.next = null;

        return cur;
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



