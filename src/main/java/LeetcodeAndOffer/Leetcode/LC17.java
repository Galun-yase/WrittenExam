package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
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


    HashMap<Character, char[]> hashMap;

    {
        hashMap = new HashMap<>();
        hashMap.put('2', new char[]{'a', 'b', 'c'});
        hashMap.put('3', new char[]{'d', 'e', 'f'});
        hashMap.put('4', new char[]{'g', 'h', 'i'});
        hashMap.put('5', new char[]{'j', 'k', 'l'});
        hashMap.put('6', new char[]{'m', 'n', 'o'});
        hashMap.put('7', new char[]{'p', 'q', 'r', 's'});
        hashMap.put('8', new char[]{'t', 'u', 'v'});
        hashMap.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations_2(String digits) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        backtrack_2(digits, 0, stringBuilder, res);

        return res;
    }

    private void backtrack_2(String digits, int index, StringBuilder sb, List<String> res) {
        if (digits.length() == sb.length() && sb.length() != 0) {
            res.add(sb.toString());
            return;
        }
        if (digits.length() == index) return;

        for (int i = index; i < digits.length(); i++) {
            char[] chars = hashMap.get(digits.charAt(i));
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];

                sb.append(c);
                backtrack_2(digits, i + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
