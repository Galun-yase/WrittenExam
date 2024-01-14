package LeetcodeAndOffer.Leetcode;

public class LC680 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;


        while (left < right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome_2(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return valid(s.substring(start + 1, end + 1)) || valid(s.substring(start, end));
            }
            start++;
            end--;
        }
        return true;


    }

    public boolean valid(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "a12345";
        System.out.println(s.substring(1, 3));
    }
}