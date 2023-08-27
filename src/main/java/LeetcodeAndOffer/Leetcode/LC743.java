package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;

public class LC743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = 100001;

        // 邻接矩阵存储边的关系
        int[][] g = new int[n][n];
        for (int[] t : g) {
            Arrays.fill(t, INF);
        }
        for (int[] time : times) {
            int uIndex = time[0] - 1;
            int vIndex = time[1] - 1;
            g[uIndex][vIndex] = time[2];
        }

        // 各节点到k的最短距离
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;

        // 每个节点无需重复访问，优先最近节点开始遍历，故已经遍历过的节点，对应信息不会改变，已经是最近的了
        boolean[] visited = new boolean[n];

        // 每个节点都计算一次，从最近的开始
        for (int i = 0; i < n; i++) {

            // 从未被访问的最近的节点开始
            int x = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (x == -1 || dist[j] < dist[x])) {
                    x = j;
                }
            }

            visited[x] = true;

            // 以找到的离源点最近的x节点，比较通过此x节点到其他节点是否会更近
            for (int p = 0; p < n; p++) {
                dist[p] = Math.min(dist[p], dist[x] + g[x][p]);
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == INF ? -1 : ans;
    }
}
