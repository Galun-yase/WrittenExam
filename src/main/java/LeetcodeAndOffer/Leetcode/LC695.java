package LeetcodeAndOffer.Leetcode;

public class LC695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        grid[x][y] = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int res = 1;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) continue;

            if (grid[newX][newY] == 1) {
                int area = dfs(grid, newX, newY);
                res += area;
            }
        }
        return res;
    }
}
