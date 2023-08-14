package LeetcodeAndOffer.Leetcode;

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
}
