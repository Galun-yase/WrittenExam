package LeetcodeAndOffer.Leetcode;

import java.util.*;

public class LC210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res = new ArrayList<>();
        // 每门课程的入度情况
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }

        // 每门课程影响了哪些课程
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            inDegree.put(a, inDegree.get(a) + 1);

            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }

        // 优先处理入度为0的课程
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
                res.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Integer course = queue.poll();

            if (!map.containsKey(course)) continue;
            List<Integer> list = map.get(course);
            for (Integer c : list) {
                inDegree.put(c, inDegree.get(c) - 1);

                if (inDegree.get(c) == 0) {
                    queue.add(c);
                    res.add(c);
                }
            }
        }

        for (int d : inDegree.values()) {
            if (d != 0) return new int[0];
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
