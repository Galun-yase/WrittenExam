package LeetcodeAndOffer.Offer.ArraysAndMatrices;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Offer50 {

    public char firstUniqChar(String s) {

        int[] ints = new int[128];

        char[] charArray = s.toCharArray();
        for (char a : charArray) {
            ints[a] = ints[a] + 1;
        }

        for (char a : charArray) {
            if (ints[a] == 1) return a;
        }
        return ' ';
    }

    public static void main(String[] args) {

        char c = new Offer50().firstUniqChar("abcda");
        System.out.println(c);

    }

}
