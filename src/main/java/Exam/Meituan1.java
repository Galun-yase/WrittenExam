package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/13 13:59
 */
public class Meituan1 {
    //美团1 100%
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(fangan(arr,m,k));
        }


    }

    private static int fangan(int[] arr, int m, int k) {
        int res = 0;
        for (int i = 0; i <= arr.length-m; i++) {
            boolean flag = true;
            for (int j = i; j < i+m; j++) {
                if (arr[j]<k){
                    flag = false;
                }
            }
            if (flag){
                res++;
            }

        }

        return res;
    }
}
