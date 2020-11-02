package Exam;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 任青成
 * @date 2020/10/19 20:27
 */
public class H3C1 {
    //"1 0 3 5 2 7"
    //753-102
    public int sub (String input) {
        // write code here
        String[] num = input.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String c:num) {
            int i = Integer.parseInt(c);
            if (i<=0 || i>=9)return -1;
            list.add(Integer.parseInt(c));
        }
        Collections.sort(list);
        int max = list.get(5)*100+list.get(4)*10+list.get(3);

        int min = 0;
        if (list.get(2)==0){
            return -1;
        }else if (list.get(1)==0){
            min = list.get(2)*100;
        }else if (list.get(0)==0){
            min = list.get(1)*100+list.get(2);
        }else {
            min = list.get(0)*100+list.get(1)*10+list.get(2);
        }
        return max-min;
    }

    public static void main(String[] args) {
        H3C1 h3C1 = new H3C1();
        int sub = h3C1.sub("-1 0 3 5 2 7");
        System.out.println(sub);
    }
}
