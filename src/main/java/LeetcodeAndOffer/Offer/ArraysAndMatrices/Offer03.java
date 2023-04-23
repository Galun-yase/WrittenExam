package LeetcodeAndOffer.Offer.ArraysAndMatrices;

public class Offer03 {

    public int findRepeatNumber(int[] nums) {
        int[] data = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (data[nums[i]] == -1) return nums[i];
            data[nums[i]] = -1;
        }
        return nums[nums.length-1];
    }


    // 采用按下标交换的手段，节省空间
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
