package Exam;

import java.util.Scanner;

public class Yitu1 {

    private static int mindes(int[][] array,int[] t, int n) {
        double[] res = new double[n-1];
        int index = 0;
        double temp = 0;
        for (int i = 0; i < n-1; i++) {
            double x2 = Math.pow(array[i][0] - array[i + 1][0], 2);
            double y2 = Math.pow(array[i][1] - array[i + 1][1], 2);
            double z2 = Math.pow(array[i][2] - array[i + 1][2], 2);
            int time = t[i + 1] - t[i];
            res[i] = (x2+y2+z2)/time;
            if (temp<res[i]){
                temp=res[i];
                index=i+1;
            }
        }
        return index;
    }





    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int[][] array = new int[n][3];
            int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                t[i] = in.nextInt();
                array[i][0]=in.nextInt();
                array[i][1]=in.nextInt();
                array[i][2]=in.nextInt();
            }
            System.out.println(mindes(array,t,n));
        }

    }

}
