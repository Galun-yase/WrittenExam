package LeetCode;


/**
 * @author 任青成
 * @date 2020/8/22 18:54
 */
//链表常用递归
public class s2 {

    int index = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null&&index!=0)return new ListNode(index);
        if (l1==null&&l2==null)return null;
        ListNode listNode;
        if (l1!=null && l2!=null){
            int sum = l1.val + l2.val + index;
            int i = sum % 10;
            index = sum / 10;
            listNode = new ListNode(i);
            listNode.next =addTwoNumbers(l1.next,l2.next);
        }else if (l1!=null){
            int sum = l1.val + index;
            int i = sum % 10;
            index = sum / 10;
            listNode = new ListNode(i);
            listNode.next=addTwoNumbers(l1.next,null);
        }
        else {
            int sum = l2.val + index;
            int i = sum % 10;
            index = sum / 10;
            listNode = new ListNode(i);
            listNode.next=addTwoNumbers(null,l2.next);
        }
        return listNode;

    }


}
