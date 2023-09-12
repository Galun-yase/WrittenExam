package LeetcodeAndOffer.Leetcode;

public class LC461 {
    public int hammingDistance(int x, int y) {
        int s = x ^ y;

        int res = 0;
        while (s != 0) {
            if ((s & 1) == 1) res++;
            s = s >> 1;
        }
        return res;
    }
}
