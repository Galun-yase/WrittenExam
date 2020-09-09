// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static int com(String s1,String s2){
        int i=0;
        while (i<s1.length() && i<s2.length()){
            if (s1.charAt(i)>s2.charAt(i))return 1;
            if (s1.charAt(i)<s2.charAt(i))return -1;
            i++;
        }
        if (i<s1.length())return 1;
        if (i<s2.length())return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int k = in.nextInt();
            HashMap<String , Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String c = in.nextLine();
                if (map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else {
                    map.put(c,1);
                }
            }
            PriorityQueue<Map.Entry<String,Integer>> heapMax = new PriorityQueue<>(k,(o1, o2) -> o1.getValue().compareTo(o2.getValue()));
            PriorityQueue<Map.Entry<String,Integer>> heapMin = new PriorityQueue<>(k,(o1, o2) -> o1.getValue().compareTo(o2.getValue()));
            for (Map.Entry<String,Integer> entry:map.entrySet()) {
                if (heapMax.peek().getValue()<entry.getValue() ||
                        (heapMax.peek().getValue()==entry.getValue() && com(heapMax.peek().getKey(),entry.getKey())==1)
                )heapMax.remove();heapMax.add(entry);
                if (heapMin.peek().getValue()>entry.getValue() ||
                        (heapMin.peek().getValue()==entry.getValue() && com(heapMin.peek().getKey(),entry.getKey())==1)
                )heapMin.remove();heapMin.add(entry);

            }
            for (int i = 0; i < k; i++) {
                Map.Entry<String, Integer> ll = heapMax.remove();
                System.out.println(ll.getKey()+" "+ll.getValue());
            }
            for (int i = 0; i < k; i++) {
                Map.Entry<String, Integer> ll = heapMin.remove();
                System.out.println(ll.getKey()+" "+ll.getValue());
            }


        }
    }



}

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int n = in.nextInt();
//            int m = in.nextInt();
//            Set[] team = new Set[m];
//            for (int i = 0; i < m; i++) {
//                int s = in.nextInt();
//                Set<Integer> set = new HashSet<>();
//                for (int j = 0; j < s; j++) {
//                    set.add(in.nextInt());
//                }
//                team[i] = set;
//            }
//
//            System.out.println(a + b);
//        }
//    }
//}

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                arr[i] = in.nextInt();
//                list.add(arr[i]);
//            }
//            for (int i = 0; i < n; i++) {
//                list.remove((Object)arr[i]);
//                Collections.sort(list);
//                System.out.println(list.get(n/2-1));
//                list.add(arr[i]);
//            }
//        }
//
//    }
//}



//    public static ArrayList<Integer> compare(int[] str1,int[] str2){
//        ArrayList<Integer> list = new ArrayList<>();
//        int i=0,j=0;
//        while (i<str1.length && j<str2.length){
//            if (str1[i]>str2[j]){
//                i++;
//            }else if (str1[i]<str2[j]){
//                j++;
//            }else {
//                list.add(str1[i]);
//                i++;
//                j++;
//            }
//        }
//        return list;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int n = in.nextInt();
//            int[] nNum = new int[n];
//            for (int i = 0; i < n; i++) {
//                nNum[i]=in.nextInt();
//            }
//            int m = in.nextInt();
//            int[] mNum = new int[m];
//            for (int i = 0; i < m; i++) {
//                mNum[i]=in.nextInt();
//            }
//            ArrayList<Integer> res;
//            if (n>=m){
//                res = compare(nNum, mNum);
//            }else {
//                res= compare(mNum,nNum);
//            }
//            for (Integer s:res) {
//                System.out.print(s+" ");
//            }
//
//        }
//
//
//
//
//    }
//
//}
