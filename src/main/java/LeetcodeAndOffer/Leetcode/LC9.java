package LeetcodeAndOffer.Leetcode;

public class LC9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);

        int first = 0;
        int last = s.length() - 1;

        while (first < last) {
            if (s.charAt(first) != s.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }

    public boolean isPalindrome_2(int x) {
        if (x < 0) return false;

        String str = String.valueOf(x);

        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
