package LeetcodeAndOffer.Leetcode;

import java.util.*;

public class LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
                }
            }
        }

        for (int d : inDegree.values()) {
            if (d != 0) return false;
        }
        return true;
    }

    public boolean canFinish_2(int numCourses, int[][] prerequisites) {
        // 每门课程的前置依赖
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        // 每门课程影响了哪些课程
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            inDegree.put(a, inDegree.get(a) + 1);

            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }


        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Integer course = queue.poll();

            if (!map.containsKey(course)) continue;
            List<Integer> list = map.get(course);
            for (Integer integer : list) {
                inDegree.put(integer, inDegree.get(integer) - 1);

                if (inDegree.get(integer) == 0) {
                    queue.add(integer);
                }
            }
        }

        for (Integer value : inDegree.values()) {
            if (value > 0) return false;
        }
        return true;
    }
}
