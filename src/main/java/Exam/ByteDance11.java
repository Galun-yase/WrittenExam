package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/8/26 22:33
 */
public class ByteDance11 {

    private static int findSumKey(int start,int end,String[] array,int key){
        int res = 0;
        for (int i = start; i <= end; i++) {
            if (Integer.valueOf(array[i])==key){
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());

        String[] user = scanner.nextLine().split(" ");

        int q = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < q; i++) {
            String[] s = scanner.nextLine().split(" ");
            int r = findSumKey(Integer.valueOf(s[0])-1,Integer.valueOf(s[1])-1,user,Integer.valueOf(s[2]));
            System.out.println(r);
        }
        scanner.close();
    }
}
