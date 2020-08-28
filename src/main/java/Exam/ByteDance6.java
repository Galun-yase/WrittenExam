package Exam;

import java.util.Scanner;

public class ByteDance6 {

    private int min(int n){
        int m=1024-n;
        if (m==0)return 0;
        int count=0;
        count+=m/64;
        m=m%64;
        count+=m/16;
        m=m%16;
        count+=m/4;
        m=m%4;
        count+=m/1;
        m=m%1;
        return count;



    }

    public static void main(String[] args) {
        ByteDance6 main=new ByteDance6();

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        System.out.println(main.min(n));
    }



}

