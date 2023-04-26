package LeetcodeAndOffer.Offer.ArraysAndMatrices;

import java.util.Arrays;

public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int top = 0;
        int down = matrix.length;

        int left = 0;
        int right = matrix[0].length;

        int[] result = new int[down * right];
        int index = 0;

        while (index < result.length) {
            for (int k = left; k < right; k++) {
                result[index++] = matrix[top][k];
            }
            for (int k = top + 1; k < down; k++) {
                result[index++] = matrix[k][right-1];
            }

            if (left < right-1 && top < down-1) {
                for (int k = right - 2; k > left; k--) {
                    result[index++] = matrix[down-1][k];
                }
                for (int k = down-1; k > top; k--) {
                    result[index++] = matrix[k][left];
                }
            }

            top++;
            left++;
            down--;
            right--;


        }
        return result;
    }

    public static void main(String[] args) {
        Offer29 offer29 = new Offer29();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] ints = offer29.spiralOrder(matrix);

        Arrays.stream(ints).forEach(System.out::println);
        System.out.println(ints);

    }
}
