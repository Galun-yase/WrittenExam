package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author 任青成
 * @date 2020/8/22 19:14
 */
public class s3 {

    public int lengthOfLongestSubstring(String s) {
        if (s==null)return 0;
        if (s.length()<=1)return s.length();
        char[] chars = s.toCharArray();
        int[] res = new int[s.length()];

        for (int i = 0; i < chars.length; i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(chars[i]);
            res[i]=1;
            for (int j = i+1; j < chars.length; j++) {
                if (set.contains(chars[j]))break;
                res[i]+=1;
                set.add(chars[j]);
            }


        }
        Arrays.sort(res);
        return res[s.length()-1];
    }

    public static void main(String[] args) {
        new s3().lengthOfLongestSubstring("abcabcbb");
    }

}
