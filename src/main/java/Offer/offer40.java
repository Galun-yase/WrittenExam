package Offer;

public class offer40 {
    //异或方法，还有其他暴力方法，复杂度差不多o(n)
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor^=array[i];
        }
        int index = 1;
        while ((index&xor)==0){
            index=index<<1;
        }
        int res1=0;
        int res2=0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&index)==0){
                res1=array[i]^res1;
            }else {
                res2=array[i]^res2;
            }
        }
        num1[0]=res1;
        num2[0]=res2;
    }
}
