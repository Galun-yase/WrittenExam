package Exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/3 9:07
 */
public class Baidu2 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i]=scanner.nextInt();
                y[i]=scanner.nextInt();
            }
            Arrays.sort(x);
            Arrays.sort(y);
            int xx = x[n - 1] - x[0];
            int yy = y[n-1] -y[0];
            int pow = (int)Math.pow(Math.max(xx, yy), 2);
            System.out.println(pow);
        }
    }
}
