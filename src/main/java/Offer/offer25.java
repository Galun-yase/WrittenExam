package Offer;

public class offer25 {
    public RandomListNode Clone(RandomListNode pHead)
    {

        if(pHead==null)return null;
        RandomListNode curr=pHead;
        while (curr!=null){
            RandomListNode clone=new RandomListNode(curr.label);
            RandomListNode next=curr.next;
            curr.next=clone;
            clone.next=next;

            curr=next;
        }

        curr=pHead;
        while (curr!=null){
            curr.next.random=curr.random==null?null:curr.random.next;
            curr=curr.next.next;

        }

        curr=pHead;
        RandomListNode pCloneHead=pHead.next;
        while (curr!=null){

            RandomListNode cloneNode=curr.next;
            curr.next=cloneNode.next;
            cloneNode.next=cloneNode.next==null?null:cloneNode.next.next;
            curr=curr.next;


        }

        return pCloneHead;
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
