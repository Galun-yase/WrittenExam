package LeetcodeAndOffer.Leetcode;

public class LC785 {
    public boolean isBipartite(int[][] graph) {

        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                if (!dfs(graph, i, 1, visited)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int n, int color, int[] visited) {
        if (visited[n] != 0) {
            if (visited[n] == color) {
                return true;
            } else {
                return false;
            }
        }

        visited[n] = color;

        for (int w : graph[n]) {
            if (!dfs(graph, w, -color, visited)) return false;
        }
        return true;
    }

    public boolean isBipartite_2(int[][] graph) {

        int[] group = new int[graph.length];

        for (int i = 0; i < group.length; i++) {

            if (group[i] == 0) {
                if (!dfs_2(graph, group, i, 1)) return false;
            }
        }
        return true;
    }

    private boolean dfs_2(int[][] graph, int[] group, int index, int color) {
        if (group[index] != 0) {
            if (group[index] == color) {
                return true;
            } else {
                return false;
            }
        }

        group[index] = color;

        for (int i : graph[index]) {
            if (!dfs_2(graph, group, i, -color)) return false;
        }

        return true;
    }
}
