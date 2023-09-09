package LeetcodeAndOffer.Leetcode;

import java.util.List;
import java.util.Stack;

public class LC445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }

        Stack<ListNode> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode();
        int carryBit = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carryBit != 0) {

            int num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int num2 = stack2.isEmpty() ? 0 : stack2.pop().val;

            int sum = num1 + num2 + carryBit;

            carryBit = sum / 10;
            int value = sum % 10;

            ListNode listNode = new ListNode(value);

            if (dummy.next == null) {
                dummy.next = listNode;
            } else {
                listNode.next = dummy.next;
                dummy.next = listNode;
            }
        }
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
}
