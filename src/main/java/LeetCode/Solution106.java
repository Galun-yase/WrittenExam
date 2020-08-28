package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution106 {
    public String compressString(String S) {
        int N=S.length();
        int i=0;
        StringBuilder sb=new StringBuilder();
        while (i<N ){
            int j=i;
            while (j<N && S.charAt(i)==S.charAt(j)){
                j++;
            }
            sb.append(S.charAt(i)).append(j-i);
            i=j;
        }
        if (sb.toString().length()>=S.length()){
            return S;
        }
        return sb.toString();
    }
}
