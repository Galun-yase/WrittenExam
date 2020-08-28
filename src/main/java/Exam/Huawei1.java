package Exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


//AC100%
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


        Collection<Integer> list=treemap.values();
        Iterator it=list.iterator();
        int temp=0;
        while (it.hasNext()){
            temp=Math.max(temp,(int)it.next());
        }

        List<String> arraylist=new ArrayList<>();
        for (Map.Entry<String,Integer> entry:treemap.entrySet()) {
            if (entry.getValue()==temp){
                arraylist.add(entry.getKey());
            }
        }
        Collections.sort(arraylist);
        System.out.println(arraylist.get(0));




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
            Huawei1.select(array);
        }


    }

}



