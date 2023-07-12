package LeetcodeAndOffer.Leetcode;

public class LC121 {
    public int maxProfit(int[] prices) {
        int[] high = new int[prices.length + 1];
        high[prices.length] = prices[prices.length - 1];

        int res = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            high[i] = Math.max(prices[i], high[i + 1]);
            res = Math.max(res, high[i]-prices[i]);
        }

        return res;
    }
}
