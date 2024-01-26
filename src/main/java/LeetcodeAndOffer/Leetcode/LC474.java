package LeetcodeAndOffer.Leetcode;

public class LC474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;

        // dp[i][j][k]
        // 1 从前i个字符串中选出若干
        // 2 使得0的个数不超过j
        // 3 使得1的个数不超过k
        // 能够选出的最多个数的字符串数目
        int[][][] dp = new int[length + 1][m + 1][n + 1];

        for (int i = 1; i < strs.length + 1; i++) {
            String str = strs[i - 1];
            int countZero = countZero(str);
            int countOne = countOne(str);

            // 注意这里从0开始，j或k为0的情况，当前字符也可能满足条件："0"/"11"
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j < countZero || k < countOne) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - countZero][k - countOne] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    private int countZero(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0') count++;
        }
        return count;
    }

    private int countOne(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        new LC474().findMaxForm_2(strs, 5, 3);
    }

    public int findMaxForm_2(String[] strs, int m, int n) {

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i < strs.length + 1; i++) {
            String str = strs[i - 1];

            int count_0 = count(str, '0');
            int count_1 = count(str, '1');

            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {

                    if (j < count_0 || k < count_1) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {

                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - count_0][k - count_1] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int count(String str, char ch) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                res++;
            }
        }
        return res;
    }
}
