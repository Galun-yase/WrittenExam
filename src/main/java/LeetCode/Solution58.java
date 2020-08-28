package LeetCode;

public class Solution58 {

    public String reverseLeftWords(String s, int n) {

        String prep=s.substring(0,n);
        String tail=s.substring(n);
        return tail+prep;

    }


}
