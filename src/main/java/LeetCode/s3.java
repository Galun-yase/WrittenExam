package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 任青成
 * @date 2020/8/22 19:14
 */
//巧妙利用边界 滑动窗口 最长子串
public class s3 {

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        int rk = -1;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (i!=0){
                occ.remove(s.charAt(i-1));
            }
            while (rk+1<n && !occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }
            ans = Math.max(ans,rk-i+1);

        }
        return ans;

    }

    public static void main(String[] args) {
        new s3().lengthOfLongestSubstring("abcabcbb");
    }

}
