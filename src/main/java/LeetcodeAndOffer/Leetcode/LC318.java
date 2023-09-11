package LeetcodeAndOffer.Leetcode;

public class LC318 {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            int bit = 0;

            for (int j = 0; j < word.length(); j++) {
                int c = word.charAt(j) - 'a';

                bit |= 1 << c;

            }
            mask[i] = bit;

        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {

                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }

            }
        }
        return res;
    }
}
