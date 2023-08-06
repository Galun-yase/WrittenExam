package LeetcodeAndOffer.Leetcode;

public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[0];
        int length = numbers.length;

        for (int i = 0; i < length - 1; i++) {
            // 负数相加会越来越小
            // if (numbers[i] > target) break;

            if (numbers[i] + numbers[i + 1] > target) break;
            if (numbers[i] + numbers[length - 1] < target) continue;

            int left = i;
            int right = length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];

                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new int[0];
    }
}
