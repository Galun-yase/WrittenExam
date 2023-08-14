package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();

        int start = 0;
        for (int end = 0; end < s.length(); end++) {

            if (end - start + 1 == p.length()) {
                if (isSame(s.substring(start, end + 1), p)) {
                    res.add(start);
                }
                start++;
            }
        }

        return res;
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
