package Offer;

public class offer40 {
    //异或方法，还有其他暴力方法，复杂度差不多o(n)
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor=0;
        for (int i = 0; i < array.length; i++) {
            xor=xor^array[i];
        }
        int index=1;
        while ((index&xor)==0){
            index = index<<1;
        }
        int result1=0;
        int result2=0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&index)==0){
                result1=result1^array[i];
            }else {
                result2=result2^array[i];
            }
        }
        num1[0]=result1;
        num2[0]=result2;


    }
}
