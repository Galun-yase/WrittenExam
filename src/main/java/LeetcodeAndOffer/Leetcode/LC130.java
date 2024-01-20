package LeetcodeAndOffer.Leetcode;

public class LC130 {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        if (board[x][y] == 'X') return;
        // 注意已经访问过被标注的区域，不能再次访问，否则会无限递归
        if (board[x][y] == 'N') return;

        board[x][y] = 'N';

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            dfs(board, newX, newY);
        }
    }

    public void solve_2(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfs_2(board, i, 0);
            dfs_2(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs_2(board, 0, i);
            dfs_2(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs_2(char[][] board, int x, int y) {
        if (board[x][y] == 'X') return;

        board[x][y] = 'S';

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (0 <= newX && newX < board.length && 0 <= newY && newY < board[0].length && board[newX][newY] == 'O') {
                dfs_2(board, newX, newY);
            }
        }
    }
}
