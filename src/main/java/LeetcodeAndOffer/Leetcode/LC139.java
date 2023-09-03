package LeetcodeAndOffer.Leetcode;

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
}
