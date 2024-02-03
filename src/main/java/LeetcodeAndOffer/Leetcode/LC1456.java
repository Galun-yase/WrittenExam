package LeetcodeAndOffer.Leetcode;

import java.util.HashSet;

public class LC1456 {
    public int maxVowels(String s, int k) {
        int count = 0;
        int res = 0;
        String str = "aeiou";

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (str.contains(Character.toString(c))) {
                count++;
            }
            if (end - start + 1 == k) {
                res = Math.max(res, count);
                if (str.contains(Character.toString(s.charAt(start)))) {
                    count--;
                }
                start++;
            }

            // 特殊情况可以日前跳出
            if (res == k) return res;
        }
        return res;
    }

    public int maxVowels_2(String s, int k) {
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('o');
        hashSet.add('i');
        hashSet.add('e');
        hashSet.add('u');

        int res = 0;
        for (int i = 0; i < k; i++) {
            if (hashSet.contains(s.charAt(i))) {
                res++;
            }
        }
        int len = res;
        for (int i = k; i < s.length(); i++) {
            if (hashSet.contains(s.charAt(i)) && !hashSet.contains(s.charAt(i - k))) {
                len++;
            }
            if (!hashSet.contains(s.charAt(i)) && hashSet.contains(s.charAt(i - k))) {
                len--;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
