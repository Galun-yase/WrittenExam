package Offer;
import java.util.ArrayList;

public class offer3 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    if (listNode==null)return new ArrayList<Integer>();

    ListNode curr=listNode;
    ListNode pre=null;

    while (curr!=null){
        ListNode temp=curr.next;
        curr.next=pre;

        pre=curr;
        curr=temp;

    }

    ArrayList<Integer> arrayList=new ArrayList<>();
    while (pre!=null){
        arrayList.add(pre.val);
        pre=pre.next;
    }
    return arrayList;

}

}
