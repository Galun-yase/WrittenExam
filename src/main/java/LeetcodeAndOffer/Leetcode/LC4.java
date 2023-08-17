package LeetcodeAndOffer.Leetcode;

public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }


        int cut1 = 0;
        int cut2 = 0;

        int LMax1 = 0;
        int LMax2 = 0;
        int RMin1 = 0;
        int RMin2 = 0;

        int left = 0;
        int right = n * 2;
        while (left <= right) {
            cut1 = left + ( right - left ) / 2;
            cut2 = m + n - cut1;

            if (cut1 == 0) {
                LMax1 = Integer.MIN_VALUE;
            } else {
                LMax1 = nums1[(cut1 - 1) / 2];
            }

            if (cut1 == 2 * n) {
                RMin1 = Integer.MAX_VALUE;
            } else {
                RMin1 = nums1[cut1 / 2];
            }

            if (cut2 == 0) {
                LMax2 = Integer.MIN_VALUE;
            } else {
                LMax2 = nums2[(cut2 - 1) / 2];
            }

            if (cut2 == 2 * m) {
                RMin2 = Integer.MAX_VALUE;
            } else {
                RMin2 = nums2[cut2 / 2];
            }

            if (LMax1 > RMin2) {
                right = cut1 - 1;
            } else if (LMax2 > RMin1) {
                left = cut1 + 1;
            } else {
                break;
            }

        }

        return (Math.max(LMax1, LMax2) + Math.min(RMin1, RMin2)) / 2.0;
    }
}
