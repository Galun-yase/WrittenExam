package Recursion;

public class Solution91 {

    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;

        char[] chars=s.toCharArray();

        return decode(chars,chars.length-1);

    }

    private int decode(char[] array,int index){

        if (index<=0)return 1;

        char curr=array[index];
        char pre=array[index-1];


        int count=0;

        if (curr>'0'){
            count+=decode(array,index-1);
        }

        if (pre=='1' || (pre=='2' && curr <='6')){
            count+=decode(array,index-2);
        }
        return count;

    }




}
