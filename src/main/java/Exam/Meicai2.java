package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/23 19:51
 */
//最长重复子串
public class Meicai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(maxsub(str));
        }
    }

    private static String maxsub(String str) {
        if (str==null||str.length()==0)return "";

        int l = 0;
        int index = 0;
        int temp =0;
        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j < str.length()-i; j++) {
                if (str.charAt(j)==str.charAt(i+j)){
                    temp++;
                }else {
                    temp=0;
                }
                if (temp>l){
                    l=temp;
                    index=j-temp+1;
                }
            }
        }
        if (l>0){
            return str.substring(index,index+l);
        }
        return "";
    }
}
