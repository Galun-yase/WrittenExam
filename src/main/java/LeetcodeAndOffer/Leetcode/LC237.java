package LeetcodeAndOffer.Leetcode;

public class LC237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode_2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
