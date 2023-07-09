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


    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));


        int a = 8;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a & (-a));
    }
}
