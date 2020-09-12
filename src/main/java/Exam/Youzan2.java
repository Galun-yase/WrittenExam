package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/11 13:08
 */
public class Youzan2 {
    public int zhongshu(int[] arr){
        int res=arr[0];
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==res){
                index++;
            }else {
                index--;
                if (index==0){
                    res = arr[i];
                    index = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String replace = s.replace("[", "").replace("]", "");
        String[] arrStr = replace.split(",");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i]=Integer.parseInt(arrStr[i]);
        }
        int zhongshu = new Youzan2().zhongshu(arr);
        System.out.println(zhongshu);
    }
}
