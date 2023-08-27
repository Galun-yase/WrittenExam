package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC684 {

    private List<List<Integer>> graph;
    private List<Boolean> visited;
    private boolean hasCycle;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        graph = new ArrayList<>(n + 1);

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            hasCycle = false;

            visited = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                visited.add(false);
            }

            dfs(edge[0], -1);

            if (hasCycle) return edge;
        }
        return null;
    }

    private void dfs(int curNode, int fatherNode) {
        visited.set(curNode, true);
        List<Integer> info = graph.get(curNode);

        for (int nextNode : info) {
            if (nextNode == fatherNode) continue;

            if (!visited.get(nextNode)) {
                dfs(nextNode, curNode);
            } else {
                hasCycle = true;
                return;
            }
        }
    }
}
