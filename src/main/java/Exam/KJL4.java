package Exam;

/**
 * @author 任青成
 * @date 2020/9/20 18:32
 */
public class KJL4 {
    //1暴力hashmap,
    //2利用位运算(与重复数字找单个同)
    private int sumone(int[] nums){
        int[] temp = new int[32];
        for (int i = 0; i < temp.length; i++) {
            int sum=0;
            for (int tt:nums) {
                sum=sum+(tt>>i&1);
            }
            temp[i]=sum;
        }
        int result=0;
        for (int i = 0; i < 32; i++) {
            if (temp[i]%3!=0){
                result=result+(1<<i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {3,2,3,3};
        int[] b ={9,4,7,9,7,9,7};
        int sumone = new KJL4().sumone(b);
        System.out.println(sumone);
    }
}
