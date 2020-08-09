package Offer;

//循环链表
public class offer46 {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }

    private Node deleteNode(Node node){
        Node p =node;
        while (p.next.val!=node.val){
            p=p.next;
        }
        p.next=node.next;
        node.next=null;
        return p.next;
    }

    public int LastRemaining_Solution1(int n, int m) {
        if (n<=0 || m<= 0)return -1;

        Node head=new Node(0);
        Node p = head;

        for (int i = 1; i < n; i++) {

            Node node=new Node(i);
            p.next=node;
            p=node;

        }
        p.next=head;

        Node pp = head;
        while (pp.next.next.val!=pp.val){
            for (int i = 1; i < m; i++) {
                pp=pp.next;
            }
            pp = deleteNode(pp);
        }
        if (m%2==0){
            return pp.val;
        }else {
            return pp.next.val;
        }
    }

    public int f(int n, int m){
        if (n==1)return 0;
        int x = f(n-1,m);
        return (m+x)%n;
    }


    //递归实现
    public int LastRemaining_Solution(int n, int m) {
        if (n<=0)return -1;
        return f(n,m);
    }

    public static void main(String[] args) {
        int i = new offer46().LastRemaining_Solution(5, 3);
        System.out.println(i);
    }




}
