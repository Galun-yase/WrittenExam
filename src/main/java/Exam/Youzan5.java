package Exam;

/**
 * @author 任青成
 * @date 2020/9/11 16:50
 */
public class Youzan5 {
        //O（n）
    public long sum (int num, int itemNum) {
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        while (itemNum>=0){
            int res = num*itemNum+temp;
            sb.append(res%10);
            temp = res/10;
            itemNum--;
        }
        return Long.parseLong(sb.reverse().toString());
    }
}
