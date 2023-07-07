package LeetcodeAndOffer.Leetcode;

public class LC137 {

    public int singleNumber(int[] nums) {


        // 每一位二进制相加 1的个数
        int[] cnt = new int[32];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            for (int j = 0; j < 32; j++) {
                int tmp = num >> j;

                int c = tmp & 1;
                if (c == 1) {
                    cnt[j] += 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < cnt.length; i++) {
            int c = cnt[i] % 3;
            if (c == 1) {
                res += 1 << i;
            }
        }
        return res;


    }

    public static void main(String[] args) {
        int[] a = {2,2,2,3};
        int i = new LC137().singleNumber(a);
    }

}
