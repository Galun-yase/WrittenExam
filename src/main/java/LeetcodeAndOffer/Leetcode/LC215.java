package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSort(int[] nums, int left, int right, int index) {
        int mid = partition(nums, left, right);

        if (mid == index) {
            return nums[mid];
        } else if (mid > index) {
            return quickSort(nums, left, mid - 1, index);
        } else {
            return quickSort(nums, mid + 1, right, index);
        }

    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left < right) {
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            nums[left] = nums[right];

            while (left < right && pivot <= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public int findKthLargest_second(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            Integer top = pq.peek();
            if (top < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        new LC215().findKthLargest_3(arr, 2);
        System.out.println();
    }

    public int findKthLargest_3(int[] nums, int k) {
        return quickSort_3(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSort_3(int[] arr, int left, int right, int k) {

        int partition = partition_3(arr, left, right);

        if (partition == k) {
            return arr[partition];
        } else if (partition < k) {
            return quickSort_3(arr, partition + 1, right, k);
        } else {
            return quickSort_3(arr, left, partition - 1, k);
        }
    }

    private int partition_3(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {
            while (left < right && pivot >= arr[right]) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = pivot;
        return left;
    }

}
