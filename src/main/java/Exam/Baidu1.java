package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/3 8:48
 */
public class Baidu1 {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int count = 0;
            for (int i = 0; i < c; i++) {
                count += arr[i];
            }
            int res = 0;
            if (count <= t) {
                res++;
            }
            for (int i = c; i < n; i++) {
                count = count - arr[i - c];
                count = count + arr[i];
                if (count <= t) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
