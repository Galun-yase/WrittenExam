package LeetcodeAndOffer.Leetcode;

public class LC1020 {
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) res++;
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if (grid[x][y] == 0) return;

        grid[x][y] = 0;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            dfs(grid, newX, newY);
        }
    }

    public int numEnclaves_2(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            dfs_2(grid, 0, i);
            dfs_2(grid, grid.length - 1, i);
        }

        for (int i = 0; i < grid.length; i++) {
            dfs_2(grid, i, 0);
            dfs_2(grid, i, grid[0].length - 1);
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs_2(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) return;
        grid[x][y] = 0;

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (0 <= newX && newX < grid.length && 0 <= newY & newY < grid[0].length && grid[newX][newY] == 1) {
                dfs_2(grid, newX, newY);
            }
        }
    }
}
