package FoundationDS;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution242 {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){return false;}
        String str1=s.toLowerCase();
        String str2=t.toLowerCase();
        int[] array=new int[26];
        for (int i=0;i<str1.length();i++){
            array[str1.charAt(i)-'a']++;
        }
        for (int i = 0; i <str2.length() ; i++) {
            array[str2.charAt(i)-'a']--;
            if (array[str2.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;

    }



    public static boolean isAnagram2(String s, String t) {
        if (s.length()!=t.length()){return false;}

        char[] str1=s.toCharArray();
        char[] str2=t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        if (Arrays.equals(str1,str2)){return true;}
        return false;

    }
}


/**
 * 典型的数组字符串类，空间换时间，1、int[26]  2、char[]
 */
