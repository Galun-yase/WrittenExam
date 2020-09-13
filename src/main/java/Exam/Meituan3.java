package Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/13 14:00
 */
//美团3
public class Meituan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 2; j++) {
                    sb.append(scanner.nextInt());
                }
                arr[i] = sb.reverse().toString();
            }
            minmn(arr);
        }


    }

    private static void minmn(String[] arr) {
        HashMap<Integer,String> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i+1,arr[i]);
        }

        ArrayList<String> list = new ArrayList<>(map.values());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            for (Map.Entry<Integer,String> entry:map.entrySet()) {
                if (entry.getValue()==list.get(i)){
                    System.out.print(entry.getKey());
                }
            }
            System.out.print(" ");
        }
    }
}
