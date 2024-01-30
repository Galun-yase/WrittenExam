package LeetcodeAndOffer.Leetcode;

public class LC8 {
    public int myAtoi(String s) {
        int n = s.length();

        int index = 0;
        boolean negative = false;
        int res = 0;

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index < n && s.charAt(index) == '-') {
            negative = true;
        }
        if (index < n && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            index++;
        }

        while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            int lastNum = s.charAt(index) - '0';

            //-2147483648
            // 2147483647
            if (!negative && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (lastNum == 8 || lastNum == 9)))) {
                return Integer.MAX_VALUE;
            }

            if (negative && (-res < Integer.MIN_VALUE / 10 || (-res == Integer.MIN_VALUE / 10 && lastNum == 9))) {
                return Integer.MIN_VALUE;
            }

            index++;
            res = res * 10 + lastNum;
        }

        return negative ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    public int myAtoi_2(String s) {
        if (s.length() == 0) return 0;

        boolean neg = false;
        int index = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index < s.length() && s.charAt(index) == '-') {
            neg = true;
        }
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            index++;
        }

        int res = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {

            int num = s.charAt(index) - '0';
            num = neg ? -num : num;

            if (res > 214748364 || (res == 214748364 && (num == 8 || num == 9))) {
                return Integer.MAX_VALUE;
            }
            if (res < -214748364 || (res == -214748364 && num == -9)) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + num;
            index++;
        }


        return res;
    }
}
