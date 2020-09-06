package Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 任青成
 * @date 2020/8/28 10:49
 */
class Node{
    public String value;
    public Node left;
    public Node middle;
    public Node right;
}
public class KJL {

    //水平输出

    public void outPlat(Node root){
        Queue<Node> queue = new LinkedList<>();
        if (root!=null){
            queue.add(root);
        }
        Queue<Node> temp = new LinkedList<>();
        while (!queue.isEmpty()||!temp.isEmpty()){
            if (temp.isEmpty()){
                printQueue(queue,temp);
            }
            if (queue.isEmpty()){
                queue.addAll(temp);
                temp.clear();
                System.out.println();
            }
        }

    }

    private void printQueue(Queue<Node> q1,Queue<Node> q2){
        while (!q1.isEmpty()){
            Node first = q1.poll();
            System.out.print(first.value+",");
            if (first.left!=null)q2.add(first.left);
            if (first.middle!=null)q2.add(first.middle);
            if (first.right!=null)q2.add(first.right);
        }
    }


    //垂直输出

    void straite(Node root){

        Stack<Node> stack = new Stack<>();
        if (root!=null)stack.add(root);
        dfs(stack);
    }

    private void dfs(Stack<Node> stack) {
        if (stack.isEmpty())return;
        Node currNode = stack.peek();
        if (currNode.left==null&&currNode.middle==null&&currNode.right==null){
            List<Node> list = new ArrayList<>(stack);
            Iterator<Node> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next().value+",");
            }


            System.out.println();
            stack.pop();
            return;
        }

        if (currNode.left!=null){
            stack.add(currNode.left);
            dfs(stack);
        }
        if (currNode.middle!=null){
            stack.add(currNode.middle);
            dfs(stack);
        }
        if (currNode.right!=null){
            stack.add(currNode.right);
            dfs(stack);
        }

    }


    public static void main(String[] args) {
        Node root = new Node();root.value="A";
        root.left=new Node();root.left.value="B";
        root.right=new Node();root.right.value="C";
        root.left.right=new Node();root.left.right.value="d";
        root.right.left=new Node();root.right.left.value="g";
        root.right.right=new Node();root.right.right.value="k";
        new KJL().outPlat(root);
        new KJL().straite(root);
    }

}
