package Offer;


import java.util.HashSet;
import java.util.Set;

/**
 * @author 任青成
 * @date 2020/8/9 17:10
 */
public class offer55 {
    //Set哈希法
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null) return null;
        ListNode t = pHead;
        Set<Integer> set = new HashSet<>();
        while (t!=null){
            if (set.contains(t.val)){
                return t;
            }else {
                set.add(t.val);
                t=t.next;
            }

        }
        return null;


    }

    //双链表法
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead==null)return null;
        ListNode fast=pHead;
        ListNode slow=pHead;

        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                break;
            }
        }
        if (fast.next==null || fast.next.next==null)return null;
        fast=pHead;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

}
