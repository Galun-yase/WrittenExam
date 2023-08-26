package LeetcodeAndOffer.Leetcode;

import java.util.*;

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
}
