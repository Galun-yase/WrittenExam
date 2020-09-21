package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/20 20:42
 */
public class DUxiaoman1 {
    private int maxkuai(String s1,String s2){
        int[] temp = new int[26];

        for (char t:s1.toCharArray()) {
            temp[t-'A']++;
        }
        int count = 0;
        for (char t:s2.toCharArray()) {
            int i = temp[t - 'A'];
            if (i!=0){
                temp[t - 'A']--;
                count++;
            }
        }
        return count;


    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            int maxkuai = new DUxiaoman1().maxkuai(s1, s2);
            System.out.println(maxkuai);

        }
    }
}
