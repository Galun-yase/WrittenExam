package LeetcodeAndOffer.Leetcode;

import java.lang.reflect.Array;

public class LC88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int index = m + n + 1;
        while (n >= 0) {


            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[index] = nums1[m];
                m--;

            } else {
                nums1[index] = nums2[n];
                n--;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 0};
        int[] b = {1};

        new LC88().merge(a, 1, b, 1);
    }
}
