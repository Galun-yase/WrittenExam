package Exam;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/11 13:21
 */
public class Youzan3 {
    public int top3(int[] arr){
        PriorityQueue<Integer> minheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (i<3){
                minheap.add(arr[i]);
            }else {
                if (minheap.peek()<arr[i]){
                    minheap.remove();
                    minheap.add(arr[i]);
                }
            }
        }
        return minheap.remove();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String replace = s.replace("[", "").replace("]", "");
        String[] arrStr = replace.split(",");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i]=Integer.parseInt(arrStr[i]);
        }
        int i = new Youzan3().top3(arr);
        System.out.println(i);
    }
}
