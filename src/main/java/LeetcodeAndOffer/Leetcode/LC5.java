package LeetcodeAndOffer.Leetcode;

public class LC5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        // dp[i][j] i-j之间的最长回文串，上三角矩阵
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLength = 1;
        int maxIndex = length - 1;

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {

                // s.charAt(i) == s.charAt(j) 不相等直接为false
                // dp[i + 1][j - 1] || j - i + 1 == 2 两个条件满足其一即可：
                //     1.dp[i + 1][j - 1]也是回文串
                //     2.长度为2，(dp[i + 1][j - 1]此时j-1>i+1必为false，所以需要根据长度来判断，例如"aa")
                if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || j - i + 1 == 2)) {
                    dp[i][j] = true;

                    if (maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        maxIndex = i;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(maxIndex, maxIndex + maxLength);
    }
}
