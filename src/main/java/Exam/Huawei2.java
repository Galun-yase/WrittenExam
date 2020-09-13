package Exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//AC87.5%  没考虑到十六进制的验证
public class Huawei2 {
//写个正则,按组匹配，十六进制
//read read[addr=0x17,mask=0xff,val=0x7],read_his[addr=0xff,mask=0xff,val=0x1],read[addr=0xf0,mask=0xff,val=0x80]

    private static void check(String key,String[] array){
        boolean flag = false;
        Pattern pattern = Pattern.compile(key + "\\[addr=(0[xX][0-9a-fA-F]+),mask=(0[xX][0-9a-fA-F]+),val=(0[xX][0-9a-fA-F]+)\\]?");
        for (String s:array) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()){
                flag = true;
                System.out.println(matcher.group(1)+" "+matcher.group(2)+" "+matcher.group(3));
            }
        }
        if (!flag){
            System.out.println("FAIL");
        }
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String key=scanner.next();
            String str=scanner.next();
            String[] array=str.split("],");
            check(key,array);
        }

    }

}

