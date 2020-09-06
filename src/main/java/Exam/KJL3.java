package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/3 18:21
 */
public class KJL3 {


    private static boolean compareStr(char[] str,int i,char[] sub){
        for (int k = 0; k < sub.length; k++) {
            if (str[i+k]!=sub[k])return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            char[] str = scanner.nextLine().toCharArray();
            char[] sub = scanner.nextLine().toCharArray();

            int res = 0;
            for (int i = 0; i < str.length-sub.length+1; i++) {
                if (compareStr(str,i,sub))res++;
            }
            System.out.println(res);
        }
        scanner.close();







    }


}
