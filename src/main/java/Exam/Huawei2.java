package Exam;

import java.util.Scanner;

//AC87.5%
public class Huawei2 {


        private static boolean check(String key,String str){
        boolean flag=false;
        if (str.startsWith(key+"[") && str.indexOf("addr")!=-1 && str.indexOf("mask")!=-1 && str.indexOf("val")!=-1){

            String[] array=str.split(",");
            System.out.println(array[0].substring(array[0].indexOf("addr")+5)+" "+array[1].substring(5)+" "+array[2].substring(4));
            flag=true;

        }
        return flag;
    }


    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);

        while (scanner.hasNext()){

            String key=scanner.next();
            String str=scanner.next();
            String[] array=str.split("],");
            array[array.length-1]=array[array.length-1].substring(0,array[array.length-1].length()-1);
            boolean flag=false;
            for (int i = 0; i < array.length; i++) {

                if (check(key,array[i])){
                    flag=true;
                }

            }
            if (!flag){
                System.out.println("FAIL");
            }




        }



    }

}

