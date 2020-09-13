package Exam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/13 14:00
 */
public class Meituan2 {
    //美团2 67
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(" ").append(scanner.nextInt());
                }
                arr[i] = sb.toString().replaceFirst(" ","");
            }
            minmn(arr,n,m);
        }


    }

    private static void minmn(String[] arr, int n, int m) {
        int res = n;
        for (int i = arr.length/2; i >=1 ; i/=2) {
            if (binary(arr,i)!=i){
                res = binary(arr,i);
                break;
            }
        }
        for (int i = 0; i < res; i++) {
            System.out.println(arr[i]);
        }


    }
    private static int binary(String[] arr,int index){
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < index; i++) {
            set.add(arr[i]);
        }
        boolean flag = true;
        for (int i = index; i < 2*index; i++) {
            if (!set.contains(arr[i])){
                flag = false;
            }
        }
        if (flag){
            return index;
        }else {
            return 2*index;
        }

    }
}
