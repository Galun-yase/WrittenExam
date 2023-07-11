package LeetcodeAndOffer.Leetcode;

public class LC200 {


    public int numIslands(char[][] grid) {

        int count = 0;
        int[][] mark = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (mark[i][j] == 0 && grid[i][j] == '1') {
                    // 需要标记数组
                    // DFS(mark, i, j, grid);

                    // 不需要标记数组
                    DFS(i, j, grid);
                    count++;
                }


            }
        }
        return count;

    }

    private void DFS(int[][] mark, int x, int y, char[][] gird) {
        mark[x][y] = 1;

        // 如下需要考虑四个方向
        // char[][] ints2 = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            if (newX < 0 || newY < 0 || newX >= mark.length || newY >= mark[0].length) {
                continue;
            }

            if (mark[newX][newY] == 0 && gird[newX][newY] == '1') {
                DFS(mark, newX, newY, gird);
            }
        }
    }

    // 不需要标记数组
    private void DFS(int x, int y, char[][] gird) {
        gird[x][y] = '0';

        // 如下需要考虑四个方向
        // char[][] ints2 = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            if (newX < 0 || newY < 0 || newX >= gird.length || newY >= gird[0].length) {
                continue;
            }

            if (gird[newX][newY] == '1') {
                DFS(newX, newY, gird);
            }
        }
    }

    // 补充并查集
    public int numIslands_union_find(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        UnionFind uf = new UnionFind(rows * cols);
        int waters = 0;

        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    waters++;
                } else {
                    for (int k = 0; k < 2; k++) {
                        int newI = dx[k] + i;
                        int newJ = dy[k] + j;

                        if (newI < rows && newJ < cols && grid[newI][newJ] == '1') {
                            uf.union(getIndex(cols, i, j), getIndex(cols, newI, newJ));
                        }
                    }
                }
            }
        }

        return uf.getCount() - waters;

    }

    private int getIndex(int n, int i, int j) {
        return n * i + j;

    }

    static class UnionFind {

        int count;
        int[] roots;

        UnionFind(int n) {
            count = n;
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
        }

        public int find(int i) {
            if (roots[i] == i) return i;
            return find(roots[i]);
        }

        public void union(int p, int q) {
            int pRoots = find(roots[p]);
            int qRoots = find(roots[q]);

            if (pRoots != qRoots) {
                roots[pRoots] = qRoots;
                count--;
            }

        }

        public int getCount() {
            return count;
        }

    }


    public static void main(String[] args) {

        char[][] ints = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] ints2 = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        int i = new LC200().numIslands(ints2);


    }
}
