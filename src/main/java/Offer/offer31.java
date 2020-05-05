package Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class offer31 {
    public String PrintMinNumber(int [] numbers) {
        int n=numbers.length;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                StringBuilder sb1=new StringBuilder();
                StringBuilder sb2=new StringBuilder();
                sb1.append(o1).append(o2);
                sb2.append(o2).append(o1);
                return Integer.valueOf(sb1.toString()).compareTo(Integer.valueOf(sb2.toString()));
            }
        });
        StringBuilder sb=new StringBuilder();
        for (Integer i:list) {
            sb.append(i);
        }
        return sb.toString();

    }
}
