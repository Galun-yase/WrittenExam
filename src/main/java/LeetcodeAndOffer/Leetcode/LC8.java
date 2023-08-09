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
}
