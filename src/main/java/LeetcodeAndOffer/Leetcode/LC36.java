package LeetcodeAndOffer.Leetcode;

public class LC36 {
    public boolean isValidSudoku(char[][] board) {

        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subBoxs = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char c = board[i][j];
                    int index = c - '0' - 1;

                    rows[i][index]++;
                    cols[j][index]++;
                    subBoxs[i / 3][j / 3][index]++;

                    if (rows[i][index] > 1 || cols[j][index] > 1 || subBoxs[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
