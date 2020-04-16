import Offer.ListNode;

public class Solution237 {
    ListNode head=new ListNode(0);

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;

    }
}



