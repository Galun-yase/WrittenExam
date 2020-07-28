package Offer;

public class offer36 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)return null;
        ListNode a = pHead1;
        ListNode b = pHead2;
        while (a!=b){
            a = a.next;
            b = b.next;
            if (a!=b){
                if (a==null)a=pHead2;
                if (b==null)b=pHead1;
            }
        }
        return a;
    }

}
