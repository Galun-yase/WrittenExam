package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC179 {
    public String largestNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            String s1 = String.valueOf(o1) + String.valueOf(o2);
            String s2 = String.valueOf(o2) + String.valueOf(o1);

            return -s1.compareTo(s2);
        }).collect(Collectors.toList());

        if (list.get(0) == 0) return "0";

        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();

    }

    public String largestNumber_2(int[] nums) {

        List<Integer> list = Arrays.stream(nums).boxed().sorted((a1, a2) -> {
            String s1 = String.valueOf(a1) + String.valueOf(a2);
            String s2 = String.valueOf(a2) + String.valueOf(a1);

            return s2.compareTo(s1);
        }).collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
        }

        String string = stringBuilder.toString();
        if (string.startsWith("0")) return "0";
        return string;
    }
}
