package Offer;

public class offer15 {
    public ListNode ReverseList(ListNode head) {

        ListNode pre=null;
        ListNode curr=head;

        while (curr!=null){

            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;

        }
        return pre;


    }
}
