package LeetcodeAndOffer.Leetcode;

public class LC7 {
    public int reverse(int x) {
        // 2147483647
        //-2147483648
        int res = 0;
        while (x != 0) {
            int lastNum = x % 10;

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (lastNum == 8 || lastNum == 9))) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && lastNum == 9)) {
                return 0;
            }

            x /= 10;
            res = res * 10 + lastNum;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
