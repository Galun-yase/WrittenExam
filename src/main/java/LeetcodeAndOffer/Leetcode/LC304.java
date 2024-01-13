package LeetcodeAndOffer.Leetcode;

public class LC304 {
    class NumMatrix {

        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            preSum = new int[matrix.length + 1][matrix[0].length + 1];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        }
    }

    class NumMatrix_2 {

        int[][] prefixSum;
        int[][] matrix_back;

        public NumMatrix_2(int[][] matrix) {
            matrix_back = matrix;
            prefixSum = new int[matrix.length + 1][matrix[0].length + 1];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = prefixSum[row2][col2];


            return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
        }
    }
}
