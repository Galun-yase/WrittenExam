package LeetcodeAndOffer.Leetcode;

public class LC37 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    /**
     * 此处的回溯要有返回值，找到值后要立即返回
     * if (backtrack(board, x, y + 1)) return true;
     */
    private boolean backtrack(char[][] board, int x, int y) {
        if (x == board.length) return true;
        if (y == board[0].length) return backtrack(board, x + 1, 0);
        if (board[x][y] != '.') return backtrack(board, x, y + 1);


        for (char i = '1'; i <= '9'; i++) {
            if (!isValid(board, x, y, i)) continue;

            board[x][y] = i;
            if (backtrack(board, x, y + 1)) return true;
            board[x][y] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;

            // 遍历所在9宫格的计算方式比较巧妙
            if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == c) return false;
        }
        return true;
    }

    /**
     * 位运算解法，优化
     */
    final int N = 9;
    private int[] rows = new int[N];
    private int[] cols = new int[N];
    private int[][] subboxs = new int[3][3];

    public void solveSudoku_bit(char[][] board) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char c = board[i][j];
                if (c == '.') {
                    count++;
                } else {
                    fillNumber(i, j, c - '1', true);
                }
            }
        }

        backtrack_bit(board, count);
    }

    private boolean backtrack_bit(char[][] board, int count) {
        if (count == 0) return true;

        int[] pos = getMinOkMaskCountPos(board);
        int x = pos[0];
        int y = pos[1];

        int mask = getMask(x, y);

        for (char i = '1'; i <= '9'; i++) {
            int index = i - '1';

            if (!testMask(mask, index)) continue;

            fillNumber(x, y, index, true);
            board[x][y] = i;
            if (backtrack_bit(board, count - 1)) return true;
            board[x][y] = '.';
            fillNumber(x, y, index, false);
        }
        return false;
    }

    private void fillNumber(int x, int y, int index, boolean fill) {
        if (fill) {
            int mask = 1 << index;
            rows[x] = rows[x] | mask;
            cols[y] = cols[y] | mask;
            subboxs[x / 3][y / 3] = subboxs[x / 3][y / 3] | mask;
        } else {
            int mask = ~(1 << index);
            rows[x] = rows[x] & mask;
            cols[y] = cols[y] & mask;
            subboxs[x / 3][y / 3] = subboxs[x / 3][y / 3] & mask;
        }
    }

    private int[] getMinOkMaskCountPos(char[][] board) {
        int count = 10;
        int[] pos = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') continue;

                int mask = getMask(i, j);
                int min = getCount(mask);

                if (min < count) {
                    count = min;
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return pos;
    }

    private int getCount(int mask) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0) count++;
        }
        return count;
    }

    private int getMask(int x, int y) {
        return rows[x] | cols[y] | subboxs[x / 3][y / 3];
    }

    private boolean testMask(int mask, int index) {
        return (mask & (1 << index)) == 0;
    }
}
