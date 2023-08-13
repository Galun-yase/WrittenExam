package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;

public class LC904 {
    public int totalFruit(int[] fruits) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int start = 0;
        for (int end = 0; end < fruits.length; end++) {
            hashMap.put(fruits[end], hashMap.getOrDefault(fruits[end], 0) + 1);

            while (hashMap.size() == 3) {
                int fruit = fruits[start];
                hashMap.put(fruit, hashMap.get(fruit) - 1);
                if (hashMap.get(fruit) == 0) {
                    hashMap.remove(fruit);
                }
                start++;
            }

            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
