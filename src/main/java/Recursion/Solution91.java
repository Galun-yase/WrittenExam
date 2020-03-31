package Recursion;

public class Solution91 {

    /**
     * 一条包含字母A-Z的消息通过以下方式进行了编码：
     * 'A'->1'B'->2…'Z'->26
     *
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     */
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
