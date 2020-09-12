package Offer;

import java.util.ArrayList;

public class offer32 {
    public int GetUglyNumber_Solution(int index) {
        if (index<=0)return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int t2=0,t3=0,t5=0;
        for (int i = 1; i < index; i++) {
            list.add(Math.min(Math.min(list.get(t2)*2,list.get(t3)*3),list.get(t5)*5));
            if (list.get(i)==list.get(t2)*2)t2++;
            if (list.get(i)==list.get(t3)*3)t3++;
            if (list.get(i)==list.get(t5)*5)t5++;
        }
        return list.get(index-1);
    }
}
//        if(index<=0)return 0;
//        ArrayList<Integer> list=new ArrayList<>();
//        list.add(1);
//        int t2=0,t3=0,t5=0,i;
//        for (i = 1; i < index; i++) {
//            list.add(i,Math.min(Math.min(list.get(t2)*2,list.get(t3)*3),list.get(t5)*5));
//            if (list.get(i)==list.get(t2)*2)t2++;
//            if (list.get(i)==list.get(t3)*3)t3++;
//            if (list.get(i)==list.get(t5)*5)t5++;
//        }
//        return list.get(index-1);