package LeetcodeAndOffer.Leetcode;

public class LC50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if ((n & 1) == 0) {
            return myPow(x * x, n / 2);
        } else {
            if (n > 0) {
                return myPow(x * x, n / 2) * x;
            } else {
                return myPow(x * x, n / 2) * (1.0 / x);
            }
        }
    }

    public double myPow_2(double x, int n) {

        if (n == 0) {
            return 1.0;
        } else if (n % 2 == 0) {
            return myPow_2(x * x, n / 2);
        } else {

            if (n > 0) {
                return myPow_2(x * x, n / 2) * x;
            } else {
                return myPow_2(x * x, n / 2) * (1.0 / x);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(-3 % 10);
    }
}
