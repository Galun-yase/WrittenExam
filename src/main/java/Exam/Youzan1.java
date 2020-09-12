package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/11 12:57
 */
public class Youzan1 {

    public boolean isJumpOut(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i]==0)return false;
            if (ischeck(array,i+array[i])){
                array[i]=0;
                i=i+array[i];
            }else {
                return true;
            }
        }
        return false;
    }

    private boolean ischeck(int[] arr , int index){
        return index>=0 && index<=arr.length-1;
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
        boolean jumpOut = new Youzan1().isJumpOut(arr);
        System.out.println(jumpOut);
    }
}
