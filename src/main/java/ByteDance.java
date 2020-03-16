import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ByteDance {

    public static String format1(String s){
        char[] ss= s.toCharArray();
        Set<Character> set=new HashSet<>();
        for (int i=0;i<ss.length;i++){
            set.add(ss[i]);
        }

        for(char n:set){
            String str=""+n+n+n;
            while (s.contains(str)){
                s=s.replace(str,""+n+n);
            }
        }
        return s;
    }
    public static String format2(String s){
        char[] list=s.toCharArray();
        String temp="";
        for (int i=0;i<list.length-3;i++){
            if (list[i]==list[i+1] &&list[i+2]==list[i+3] ){
                list[i+3]=' ';
            }
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<list.length;j++){
                sb.append(list[j]);
            }
            String temps=sb.toString();
            temps.replace(" ","");
            temp=temps.toString();

        }
        return temp;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {


        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        scanner.nextLine();
        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
        List<String> list= new ArrayList<>();
        list.add(str1);
        list.add(str2);

        for (int i=0;i<N;i++){

            String temp1=ByteDance.format1(list.get(i));
            String temp2=ByteDance.format2(temp1);
            System.out.println(temp2);



        }



    }
}
