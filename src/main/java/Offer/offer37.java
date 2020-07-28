package Offer;

import java.util.Arrays;
import java.util.Collections;

public class offer37 {
    public int GetNumberOfK01(int [] nums , int target) {

        int lbound = 0, rbound = 0;
        // 寻找上界
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        lbound = l;
        // 寻找下界
        l = 0;
        r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        rbound = l;
        return rbound - lbound;
    }

    public static  int GetNumberOfK(int [] array , int k) {
        long count = Arrays.stream(array).parallel().filter(e -> e == k).count();
        return (int)count;
    }

    public static void main(String[] args) {
        int[] array={1,2,2,2,3};
        int i = offer37.GetNumberOfK(array, 2);
        System.out.println(i);
    }
}
