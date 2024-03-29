package LeetcodeAndOffer.Offer.ArraysAndMatrices;

public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
