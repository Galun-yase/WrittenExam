package Offer;

import java.util.Arrays;

/**
 * @author 任青成
 * @date 2020/8/9 14:06
 */
public class offer52 {

    public boolean match(char[] str, char[] pattern) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (char i:str) {
            sb1.append(i);
        }
        for (char i:pattern) {
            sb2.append(i);
        }


        return sb1.toString().matches(sb2.toString());


    }

    public static void main(String[] args) {
        char[] ints = new char[2];
        String string = Arrays.toString(ints);
        System.out.println(string);
    }

}
