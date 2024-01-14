package LeetcodeAndOffer.Leetcode;

public class LC292 {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public boolean canWinNim_2(int n) {
        return n % 4 == 0;
    }
}
