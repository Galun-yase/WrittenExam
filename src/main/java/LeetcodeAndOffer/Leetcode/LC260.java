package LeetcodeAndOffer.Leetcode;

public class LC260 {
    public int[] singleNumber(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        // 获取最低位有效位的二进制位
        int k = sum & (-sum);
        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((num & k) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public int[] singleNumber_second(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        int k = Integer.lowestOneBit(sum);
        int a = 0;
        int b = 0;

        for (int num : nums) {

            if ((k & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));


        int a = 8;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.lowestOneBit(a));
    }

    public int[] singleNumber_3(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        int index = Integer.lowestOneBit(res);
        int a = 0;
        int b = 0;

        for (int num : nums) {

            if ((index & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
