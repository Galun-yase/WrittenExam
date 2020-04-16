package Offer;

public class offer14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null || k<=0)return null;

        ListNode fast=head;
        ListNode low=head;


        for (int i = 1; i < k; i++) {
            fast=fast.next;
            if(fast==null)return null;
        }

        while (fast.next!=null){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }
}
