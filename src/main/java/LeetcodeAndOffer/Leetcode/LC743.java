package LeetcodeAndOffer.Leetcode;

import java.util.*;

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

    public int networkDelayTime_2(int[][] times, int n, int k) {
        int INF = 10001;

        int[][] g = new int[n + 1][n + 1];
        for (int[] ints : g) {
            Arrays.fill(ints, INF);
        }

        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];

            int sIndex = time[0];
            int tIndex = time[1];
            g[sIndex][tIndex] = time[2];
        }

        //从k出发到各点的最近距离
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;

        // 会导致n次遍历完后，还有节点没遍历到。已访问过的节点再次访问数据不会改变
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {

            int x = -1;
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && (x == -1 || dist[x] > dist[j])) {
                    x = j;
                }
            }

            visited[x] = true;

            for (int j = 1; j < n + 1; j++) {
                dist[j] = Math.min(dist[j], dist[x] + g[x][j]);
            }
        }

        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == INF ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] ints = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        new LC743().networkDelayTime_2(ints, 4, 2);
    }
}
