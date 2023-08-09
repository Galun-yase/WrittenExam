package LeetcodeAndOffer.Leetcode;

public class LC67 {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int numA = i >= 0 ? a.charAt(i) - '0' : 0;
            int numB = j >= 0 ? b.charAt(j) - '0' : 0;

            int sum = numA + numB + carry;

            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}
