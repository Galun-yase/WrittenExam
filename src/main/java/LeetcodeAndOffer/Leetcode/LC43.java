package LeetcodeAndOffer.Leetcode;

public class LC43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        // 最大m+n位，最小m+n-1位
        int[] numArray = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int i1 = num1.charAt(i) - '0';
                int i2 = num2.charAt(j) - '0';

                numArray[i + j + 1] += i1 * i2;
            }
        }

        for (int i = numArray.length - 1; i > 0; i--) {
            numArray[i - 1] += numArray[i] / 10;
            numArray[i] = numArray[i] % 10;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numArray.length; i++) {
            if (i == 0 && numArray[i] == 0) continue;
            stringBuilder.append(numArray[i]);
        }
        return stringBuilder.toString();
    }
}
