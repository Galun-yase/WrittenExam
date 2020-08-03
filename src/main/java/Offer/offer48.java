package Offer;

import java.util.Arrays;
import java.util.Collections;

public class offer48 {

    //异或(加) 与(进位)
    public int Add(int num1,int num2) {
        int result=num1;
        int carry =0;
        while (num2!=0){
            result = num1 ^ num2;
            carry = (num1 & num2)<<1;
            num1=result;
            num2=carry;
        }
        return result;
    }

    public static void main(String[] args) {
        new offer48().Add(1,2);
    }

}
