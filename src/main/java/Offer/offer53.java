package Offer;

/**
 * @author 任青成
 * @date 2020/8/9 14:31
 */
public class offer53 {



    /**
     * +，-只能放在首位或者E,e的后面
     * E或e，以及小数点只能出现一次，并且：在有E或者e的情况下，小数点不能在E，e后面出现
     * 不能有除了数字，E，e，小数点，+，-之外的其他字符出现
     * e或E后面必须出现数字，如果后面是+或-，continue，继续判单有没有数字，直到找到为止。
     * 不能是空符号串
     */
    public boolean isNumeric(char[] str) {
        if (str.length<=0)return false;
        String s = new String(str);
        String pattern = "[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?";
        return s.matches(pattern);
    }

    public static void main(String[] args) {

        double v = Double.parseDouble("2E3");

        System.out.println(v);

    }

}
