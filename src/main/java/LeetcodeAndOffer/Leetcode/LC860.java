package LeetcodeAndOffer.Leetcode;

public class LC860 {

    // 暴力解法
    public boolean lemonadeChange(int[] bills) {
        int[] pay = new int[]{0, 0, 0};
        for (int b : bills) {
            if (b == 5) {
                pay[0]++;
            } else if (b == 10) {
                if (pay[0] == 0) return false;
                pay[0]--;
                pay[1]++;
            } else {
                if (pay[1] == 0 && pay[0] < 3) return false;
                if (pay[1] >= 1 && pay[0] == 0) return false;
                if (pay[1] == 0) {
                    pay[0] -= 3;
                } else {
                    pay[0]--;
                    pay[1]--;
                }
                pay[2]++;
            }
        }
        return true;
    }

}
