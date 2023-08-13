package LeetcodeAndOffer.Leetcode;

public class LC76 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int count = t.length();
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int minLength = s.length() + 1;
        int left = 0;

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map[c] > 0) {
                count--;
            }
            map[c]--;

            while (count == 0) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    left = start;
                }

                // 已经出现的元素，且等于0，那么必为t中的元素，否则不再t中的元素都为负数
                // 在t中也为负数，说明有超过t中单字符个数的元素
                if (map[s.charAt(start)] == 0) {
                    count++;
                }
                map[s.charAt(start)]++;
                start++;
            }
        }
        return minLength == s.length() + 1 ? "" : s.substring(left, left + minLength);
    }
}
