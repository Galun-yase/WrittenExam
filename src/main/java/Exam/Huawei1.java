package Exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


//AC100% 先检查是否合法，在放入map中计数，最后做一个字典序排序
public class Huawei1 {

    private static void select(String[] array){
        TreeMap<String,Integer> treemap=new TreeMap<>();
        for (String e:array) {
            if (treemap.containsKey(e)){
                treemap.replace(e,treemap.get(e),treemap.get(e)+1);
            }else {
                treemap.put(e,1);
            }
        }
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(treemap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue()>o2.getValue()){
                    return -1;
                }else if (o1.getValue()<o2.getValue()){
                    return 1;
                }else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        System.out.println(list.get(0).getKey());




    }

    private static boolean check(String[] array){
        for (int i = 0; i < array.length; i++) {
            char ch=array[i].charAt(0);
            if (ch<'A' || ch>'Z')return false;
            for (int j = 1; j < array[i].length(); j++) {
                    char ch2=array[i].charAt(j);
                    if ('a'>ch2 || ch2>'z')return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] array=scanner.next().split(",");
            if (!check(array)){
                System.out.println("error.0001");
                break;
            }
            select(array);
        }


    }

}



