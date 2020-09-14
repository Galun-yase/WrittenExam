package Exam;

import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/13 20:00
 */
public class Didi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            String str = scanner.nextLine();
            System.out.println(reverse(str,n));
        }
    }

    private static String reverse(String str, int n) {
        int i=0;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (char c:str.toCharArray()) {
            temp.append(c);
            i++;
            if (i%n==0){
                sb.append(temp.reverse());
                temp.delete(0,n);
            }
        }
        return sb.append(temp.reverse()).toString();
    }
}
