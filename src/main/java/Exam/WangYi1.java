package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/8/28 21:51
 */
public class WangYi1 {

    //[1,5,7,2]
    private static void computer(String[] array){
        int A = Integer.valueOf(array[0]);
        int B = Integer.valueOf(array[1]);
        int p = Integer.valueOf(array[2]);
        int q = Integer.valueOf(array[3]);
        System.out.println(dfs(A,B,p,q));

    }

    private static int dfs(int A,int B, int p,int q){
        int count = 0;
        if (B<=A)return count;
        if (B<=A+p)return count+1;
        int count1 = dfs(A + p, B, p, q);
        int count2 = dfs(A , B, p*q, q);

        return Math.min(count1,count2)+1;


    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.valueOf(scanner.nextLine());
        String[][] arr = new String[n][4];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine().split(" ");
        }
        scanner.close();

        for (int i = 0; i < n; i++) {
            computer(arr[i]);
        }


    }

}
