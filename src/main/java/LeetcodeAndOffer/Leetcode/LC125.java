package LeetcodeAndOffer.Leetcode;

public class LC125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                if (left > right) return true;
            }

            while (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    public boolean isPalindrome_2(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            while (start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start > end) break;

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }
}
