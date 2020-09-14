package Exam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/13 20:51
 */
public class Didi2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                int k = scanner.nextInt();
                int[][] arr = new int[n+1][n+1];
                for (int j = 0; j < m; j++) {
                    int ii = scanner.nextInt();
                    int jj = scanner.nextInt();
                    int p = scanner.nextInt();
                    arr[ii][jj] = p>k?0:p;
                }
                System.out.println(isbuild(arr,n,k));
            }
        }
    }

    private static String isbuild(int[][] arr, int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j]!=0 && (i==1||set.contains(i)||set.contains(j))){
                    set.add(i);
                    set.add(j);
                }
            }
        }
        if (set.size()==n){
            return "Yes";
        }else {
            return "No";
        }

    }
}
