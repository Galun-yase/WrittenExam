package Offer;

public class offer49 {

    public int StrToInt(String str) {
        char[] strChar = str.toCharArray();

        for (char x:strChar) {
            if (!(('0'<=x && x<='9') || x == '-' || x == '+')){
                return 0;
            }
        }

        char[] res;
        if (str.startsWith("-")||str.startsWith("+")){
            res = str.substring(1).toCharArray();
        }else {
            res = str.toCharArray();
        }
        int result=0;
        int radix=1;
        for (int i = res.length-1; i >=0; i--) {
            int temp = res[i] - '0';
            result =result + temp * radix;
            radix = radix*10;
        }
        if (str.startsWith("-")){
            return 0-result;
        }
        return result;


    }

    public static void main(String[] args) {
        new offer49().StrToInt("123");
    }

}
