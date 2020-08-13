package Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author 任青成
 * @date 2020/8/13 0:41
 */
//暴力解法logn  其实可以参考堆 也没有优化多少吧，明天可以试一下
public class offer63 {

    private ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        if (list.size()%2!=0){
            return new Double(list.get(list.size()/2));
        }else {
            int i = list.size() / 2;
            double v = (new Double(list.get(i - 1)) + new Double(list.get(i))) / 2;
            return v;
        }

    }


    //堆的实现 巧用大顶堆和小顶堆  PriorityQueue默认为小顶堆
    PriorityQueue<Integer> little = new PriorityQueue<>();
    PriorityQueue<Integer> big = new PriorityQueue<>((o1,o2)->-o1.compareTo(o2));

    int count;
    public void Insert1(Integer num) {
        count++;
        if (count%2==1){
            if (little.peek()!=null && num >little.peek()){
                little.add(num);
                num=little.remove();
            }
            big.add(num);
        }else {
            if (!big.isEmpty() && big.peek()>num){
                big.add(num);
                num=big.remove();
            }
            little.add(num);
        }

    }

    public Double GetMedian1() {
        double res;
        if (count%2==1){
            res = big.peek();
        }else {
            res = (big.peek()+little.peek())/2.0;
        }
        return res;
    }

    public static void main(String[] args) {
        double v = new Double(1) / new Double(2);
        System.out.println(v);
    }

}
