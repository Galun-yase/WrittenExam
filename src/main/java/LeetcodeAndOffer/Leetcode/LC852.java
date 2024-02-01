package LeetcodeAndOffer.Leetcode;

public class LC852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }

            if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray_2(int[] arr) {
        int left = 1;
        int right = arr.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
                continue;
            }
            if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                right = mid - 1;
                continue;
            }
        }
        return left;
    }
}
