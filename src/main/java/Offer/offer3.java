package Offer;
import java.util.ArrayList;
import java.util.List;

public class offer3 {
    //树先序递归
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode==null)return new ArrayList<Integer>();
        list= printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }

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
