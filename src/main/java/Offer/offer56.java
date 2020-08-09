package Offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author 任青成
 * @date 2020/8/9 18:32
 */
public class offer56 {


    public ListNode deleteDuplication(ListNode pHead) {
        Map<Integer,Integer> map =new HashMap<>();
        if (pHead==null)return null;
        ListNode temp = pHead;
        while (temp!=null){
            if (map.containsKey(temp.val)){
                map.put(temp.val,map.get(temp.val)+1);
            }else {
                map.put(temp.val,1);
            }
            temp=temp.next;
        }
        temp=pHead;
        while (temp!=null && temp.next!=null){
            while (temp.next!=null && map.get(temp.next.val)!=1){
                temp.next=temp.next.next;
            }
            temp = temp.next;
        }
        if (map.get(pHead.val)!=1)return pHead.next;
        return pHead;
    }

}
