package LeetcodeAndOffer.Offer;

public class Offer51 {
    private int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort_second(nums, 0, nums.length - 1);

        return count;
    }

    private void mergeSort_second(int[] seqList, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort_second(seqList, left, mid);
        mergeSort_second(seqList, mid + 1, right);
        mergeTwoArray(seqList, left, mid, right);
    }

    private void mergeTwoArray(int[] seqList, int start, int mid, int end) {
        int[] tmp = new int[seqList.length];
        int left = start;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= end) {
            if (seqList[left] <= seqList[right]) {
                tmp[index] = seqList[left];
                left++;
            } else {
                tmp[index] = seqList[right];
                right++;

                count += mid - left + 1;
            }
            index++;
        }

        while (left <= mid) {
            tmp[index] = seqList[left];
            index++;
            left++;
        }

        while (right <= end) {
            tmp[index] = seqList[right];
            index++;
            right++;
        }

        // 临时数组从第一个元素开始存储
        index = 0;
        while (start <= end) {
            seqList[start++] = tmp[index++];
        }
    }
}
