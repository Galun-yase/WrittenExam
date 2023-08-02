package LeetcodeAndOffer.Leetcode;

public class LC122 {
    public int maxProfit(int[] prices) {
        int res = 0;

        int high = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] < high) {
                res += high - prices[i];
            }
            high = prices[i];

        }
        return res;

    }
}
