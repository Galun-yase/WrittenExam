package Offer;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 任青成
 * @date 2020/8/13 22:23
 */
//堆即可， PriorityQueue即可实现，这个真好用，以前咋没发现
public class offer64 {

    PriorityQueue<Integer> dump = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length<size || size<=0)return list;
        for (int i = 0; i < size; i++) {
            dump.add(num[i]);
        }
        int p1 = 0;
        int p2 = size-1;
        while (p2 < num.length-1){
            list.add(dump.peek());
            dump.remove(num[p1]);
            p1++;
            p2++;
            dump.add(num[p2]);
        }
        list.add(dump.peek());
        return list;

    }

    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> arrayList = new offer64().maxInWindows(a, 3);
        System.out.println(arrayList);
    }


}
