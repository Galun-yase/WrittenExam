package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;

public class LC881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = people.length;

        int left = 0;
        int right = people.length - 1;

        while (left < right) {
            if (left + 1 < people.length && people[left] + people[left + 1] > limit) return res;

            int sum = people[left] + people[right];

            if (sum <= limit) {
                res--;
                left++;
            }
            right--;
        }

        return res;
    }

    public int numRescueBoats_2(int[] people, int limit) {
        Arrays.sort(people);

        int res = 0;
        int left = 0;
        int right = people.length - 1;

        while (left < right) {

            if (people[left] + people[right] > limit) {
                res++;
                right--;
            } else {
                res++;
                right--;
                left++;
            }
        }
        if (left == right) {
            res++;
        }
        return res;
    }
}
