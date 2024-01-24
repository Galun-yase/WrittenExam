package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        Set<String> set = new HashSet<>(wordDict);

        // dp[i] 代表i之前的字符能否被拆分
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        for (int i = 1; i < length + 1; i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    public boolean wordBreak_2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0] = set.contains(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {

                String sub = s.substring(j, i + 1);

                if ((j == 0 || dp[j - 1]) && set.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        new LC139().wordBreak_2("ab", list);
    }
}
