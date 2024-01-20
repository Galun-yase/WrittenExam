package LeetcodeAndOffer.Leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LC433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] chars = {'A', 'C', 'G', 'T'};

        HashSet<String> bankSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        Collections.addAll(bankSet, bank);

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();

                if (endGene.equals(str)) return depth;

                for (char c : chars) {

                    char[] charArray = str.toCharArray();
                    for (int j = 0; j < charArray.length; j++) {
                        char tmp = charArray[j];
                        charArray[j] = c;

                        String updatedStr = new String(charArray);

                        if (bankSet.contains(updatedStr) && !visited.contains(updatedStr)) {
                            queue.add(updatedStr);
                            visited.add(updatedStr);
                        }

                        charArray[j] = tmp;
                    }

                }


            }
            depth++;
        }
        return -1;
    }

    public int minMutation_2(String startGene, String endGene, String[] bank) {
        HashSet<String> set = Arrays.stream(bank).collect(Collectors.toCollection(HashSet::new));

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);

        char[] chars = {'A', 'C', 'G', 'T'};

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (endGene.equals(str)) return depth;

                char[] charArray = str.toCharArray();

                for (int j = 0; j < str.length(); j++) {
                    for (char aChar : chars) {

                        char old = charArray[j];
                        charArray[j] = aChar;
                        String newStr = new String(charArray);
                        if (set.contains(newStr) && !visited.contains(newStr)) {
                            queue.add(newStr);
                            visited.add(newStr);
                        }

                        charArray[j] = old;
                    }
                }
            }
            depth++;
        }
        return -1;
    }


    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        new LC433().minMutation_2(start, end, bank);
    }
}
