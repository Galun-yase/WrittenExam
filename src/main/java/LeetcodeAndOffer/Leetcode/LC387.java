package LeetcodeAndOffer.Leetcode;

public class LC387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }
}
