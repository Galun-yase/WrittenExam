package LeetCode;

/**
 * @author 任青成
 * @date 2020/8/23 22:46
 */
public class s4 {

//    输入: "babad"
//    输出: "bab"
//    注意: "aba" 也是一个有效答案。
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    //暴力法 中心扩散法，可以优化到O(n2) 动态规划 二维数组 空间换时间
    public String longestPalindrome(String s) {
        if (s.length()==1)return s;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i)!=s.charAt(j)){
                    int res = j-i;
                    int ii = i-1;int jj = j;
                    while (ii>=0 && jj<s.length() && s.charAt(ii)==s.charAt(jj)){
                        res+=2;
                        ii--;
                        jj++;
                    }
                    String substring =jj >= s.length() ?    s.substring(ii+1):s.substring(ii+1,jj);

                    str = str.length()>=substring.length()?str:substring;
                    break;
                }
                if (j==s.length()-1 && str.length()<s.substring(i).length())str = s.substring(i);
            }
        }
        return str;
    }


    //动态规划 o(n2)
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }

    public static void main(String[] args) {
        String aba = new s4().longestPalindrome("abcdcbb");
        System.out.println(aba);
    }

}
