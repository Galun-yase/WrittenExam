package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;
import java.util.Map;

public class LC135 {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < ratings.length; i++) {
            // 取最大值不影响规则变化：
            // 比如 ratings[A] > ratings[B]
            // 左规则需满足left[B]不会比left[A]大，left[A]>=left[B]
            // 右规则需满足right[A]一定大于right[B],right[A]>right[B]
            // 更新后A变大，还是满足左右规则
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

    public int candy_2(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1 - 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(left[i], right[i]);
        }

        return res + ratings.length;
    }

    public static void main(String[] args) {
        int[] r = {1, 0, 2};
        new LC135().candy_2(r);
    }
}
