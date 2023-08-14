package LeetcodeAndOffer.Leetcode;

public class LC567 {
    public boolean checkInclusion(String s1, String s2) {
        int start = 0;
        for (int end = 0; end < s2.length(); end++) {

            if (end - start + 1 == s1.length()) {
                if (isSame(s2.substring(start, end + 1), s1)) {
                    return true;
                }
                start++;
            }
        }

        return false;
    }

    private boolean isSame(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] array = new int[26];
        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            array[c1 - 'a']++;
            array[c2 - 'a']--;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) return false;
        }
        return true;
    }
}
