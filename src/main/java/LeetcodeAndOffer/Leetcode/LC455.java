package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;

public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }

    public int findContentChildren_2(int[] g, int[] s) {
        int[] arrayG = Arrays.stream(g).sorted().toArray();
        int[] arrayS = Arrays.stream(s).sorted().toArray();

        int index = 0;
        for (int i = 0; i < arrayS.length; i++) {

            if (index<arrayG.length && arrayG[index] <= arrayS[i]) {
                index++;
            }
        }
        return index;

    }
}
