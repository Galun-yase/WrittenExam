package LeetcodeAndOffer.Offer;

import java.util.Arrays;

public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int[] res = new int[matrix.length * matrix[0].length];

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int index = 0;

        while (true) {
            for (int i = left; i <= right; i++) {
                res[index] = matrix[top][i];
                index++;
            }
            top++;

            if (top > bottom || left > right) break;

            for (int i = top; i <= bottom; i++) {
                res[index] = matrix[i][right];
                index++;
            }
            right--;

            if (top > bottom || left > right) break;

            for (int i = right; i >= left; i--) {
                res[index] = matrix[bottom][i];
                index++;
            }
            bottom--;

            if (top > bottom || left > right) break;

            for (int i = bottom; i >= top; i--) {
                res[index] = matrix[i][left];
                index++;
            }
            left++;

            if (top > bottom || left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] ints = new Offer29().spiralOrder(matrix);
        Arrays.stream(ints).forEach(System.out::println);

        // 1,2,3,4
        // 5,6,7,8
        // 9,10,11,12
    }
}
