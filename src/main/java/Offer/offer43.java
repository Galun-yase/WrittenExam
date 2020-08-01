package Offer;

public class offer43 {

    //字符串？？？咋那么简单？？中等？？
    public String LeftRotateString(String str,int n) {

        if (str==null || str.length()<=1)return str;
        return new StringBuilder(str.substring(n)).append(new StringBuilder(str.substring(0,n))).toString();


    }


}
