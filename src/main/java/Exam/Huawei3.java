package Exam;

import java.util.ArrayList;
import java.util.Scanner;

//AC10% 图dfs遍历
public class Huawei3 {
    //求图的当前结点的第一个邻结点
    static int firstNeig(int[][] graph,int v,int N){
        for(int i=0;i<N;i++)
            if(graph[v][i]>0) return i;
        return -1;
    }

    //求图的当前结点的下一个邻结点
    static int nextNeig(int[][] graph,int v,int w,int N){
        for(int i=w+1;i<N;i++)
            if(graph[v][i]>0) return i;
        return -1;
    }

    //图的深度优先遍历
    static int dfs(int[][] graph,int v,int N,int[] weight,int curStack,int maxStack){
        curStack+=weight[v]; //进入每层时先加上当前函数栈空间的大小
        int temp=curStack;  //temp保存进入该层时curStack的大小
        int w=firstNeig(graph,v,N); //寻找v的第一个邻结点w
        while(w!=-1){ //w存在
            maxStack = dfs(graph,w,N,weight,curStack,maxStack);  //遍历
            maxStack=maxStack>curStack?maxStack:curStack; //每层求得的大小与当前最大值做对比
            curStack=temp; //curStack更新为进入该层时的大小
            w=nextNeig(graph,v,w,N); //寻找下一个邻结点
        }
        return maxStack;
    }

    //getMaxStack()函数返回结果
    public static int getMaxStack(int[][] graph,int weight[],int N){
        int maxStack=0;
        for(int i=0;i<N;i++){
            int curStack=0; //当前入口调用链栈的总和置0
            maxStack = dfs(graph,i,N,weight,curStack,maxStack); //深度优先遍历
        }
        return maxStack; //输出最大栈总和
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt(); //函数组数
            int[] numOfFun = new int[N];//函数调用个数矩阵
            int[] weight = new int[N];//函数栈空间

            for(int i=0;i<N;i++){
                numOfFun[i] = scanner.nextInt();
            }

            int[][] graph = new int[100][100]; //邻接矩阵
            int input;
            for(int i=0;i<N;i++)
                for(int j=0;j<numOfFun[i]+2;j++){
                    input = scanner.nextInt(); //根据每个函数调用数目输入
                    if(j>0){ //函数编号不要
                        if(j==1){ //第一个赋值给weight[]
                            if(input==0) {
                                System.out.println("NA");
                            } //栈为0跳出
                            weight[i]=input;
                        }
                        else if(input==i+1){
                            System.out.println("R");} //自己调用自己跳出
                        else graph[i][input-1]=weight[i];
                    }
                }
            System.out.println(getMaxStack(graph,weight,N));
        }
    }





    }

//    public static void main(String[] args) {
//            Scanner scanner=new Scanner(System.in);
//            while (scanner.hasNext()){
//                int n=scanner.nextInt();
//                int[] array=new int[n];
//                for (int i = 0; i < n; i++) {
//                    array[i]=scanner.nextInt();
//                }
//
//                ArrayList<Integer>[] arr=new ArrayList[n];
//                for (int i = 0; i < n; i++) {
//
//                    arr[i]=new ArrayList<Integer>();
//                    for (int j = 0; j < array[i]+2; j++) {
//                        arr[i].add(scanner.nextInt());
//                    }
//
//                }
//                int temp=0;
//                for (int i = 0; i < n; i++) {
//                    temp+=arr[i].get(1);
//
//                }
//                System.out.println(temp);
//
//
//
//
//
//            }
//        }
