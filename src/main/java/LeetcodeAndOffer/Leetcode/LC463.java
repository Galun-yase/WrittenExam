package LeetcodeAndOffer.Leetcode;

public class LC463 {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int x, int y) {
        // 碰到边可以贡献一个边长
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return 1;

        // 碰到一个水域可以贡献一个边长
        if (grid[x][y] == 0) return 1;

        // 已经访问过的水域不能贡献
        if (grid[x][y] == 2) return 0;
        grid[x][y] = 2;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        int res = 0;
        for (int i = 0; i < 4; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            int c = dfs(grid, newX, newY);

            res += c;
        }
        return res;
    }

    public int islandPerimeter_2(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs_2(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs_2(int[][] grid, int x, int y) {
        grid[x][y] = -1;

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        int res = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (0 <= newX && newX < grid.length && 0 <= newY && newY < grid[0].length) {
                if (grid[newX][newY] == 1) {
                    res += dfs_2(grid, newX, newY);
                }
                if (grid[newX][newY] == 0) {
                    res++;
                }
            } else {
                res++;
            }

        }
        return res;
    }
}
