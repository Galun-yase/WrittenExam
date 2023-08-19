package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC17 {
    char[][] map = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        backtrack(digits, 0, sb);

        return res;
    }

    private void backtrack(String digits, int start, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            char c = digits.charAt(i);
            int index = c - '2';
            char[] chars = map[index];

            for (int j = 0; j < chars.length; j++) {

                sb.append(chars[j]);
                backtrack(digits, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<String> letterCombinations_second(String digits) {
        if (digits.length() == 0) return new ArrayList<>();


        dfs(digits, 0, "");

        return res;
    }

    private void dfs(String digits, int start, String sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char c = digits.charAt(start);
        int index = c - '2';
        char[] chars = map[index];

        for (int i = 0; i < chars.length; i++) {
            dfs(digits, start + 1, sb + chars[i]);
        }
    }
}
