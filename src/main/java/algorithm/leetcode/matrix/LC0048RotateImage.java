package algorithm.leetcode.matrix;

import java.util.Arrays;

public class LC0048RotateImage {

    class Solution {
        public void rotate(int[][] matrix) {

            System.out.println("Matrix original");
            Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

            /*
            N = 3 * 3
            0 row -> 2 row
            1 row -> 1 row
            2 row 重複了不要再算，會把上一個 0 row -> 2 row 又換回來

            N = 4 * 4
            0 row -> 3 row
            1 row -> 2 row
            2 row 重複了不要再算，會把上一個 1 row -> 2 row 又換回來

            所以只要算到 < matrix.length/2 就好
             */
            for (int i = 0; i < matrix.length / 2; i++) {
                int[] temp = matrix[matrix.length - 1 - i];
                matrix[matrix.length - 1 - i] = matrix[i];
                matrix[i] = temp;
            }

            System.out.println("Matrix after swap row");
            Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

            /*
            主對角線不會動，不用 swap

            N = 3 * 3
            (0,0) 主對角線
            (0,1) -> (1,0)
            (0,2) -> (2,0)
            (1,0) -> (0,1) 重複了不要再算，會把上一個 (0,1) -> (1,0) 又換回來
            (1,1) 主對角線
            (1,2) -> (2,1)

            N = 4 * 4
            (0,0) 主對角線
            (0,1) -> (1,0)
            (0,2) -> (2,0)
            (0,3) -> (3,0)
            (1,0) 重複
            (1,1) 主對角線
            (1,2) -> (2,1)
            (1,3) -> (3,1)
            (2,0) 重複
            (2,1) 重複
            (2,2) 主對角線
            (2,3) -> (3,2)

            每次 i 迭代的時候，j 都會從 i + 1 開始起算
            例如第二列從 (1,2) 開始算即可、第三列從 (2,3) 開始算即可
             */

            for (int i = 0; i < matrix.length; i++) {
                for (int j = i+1; j < matrix.length; j++) {
                    // System.out.printf("(%d,%d)\n", i, j);
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }

            System.out.println("Matrix after swap symmetry");
            Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

        }
    }

    public int[][] generateTest1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        return matrix;
    }

    public int[][] generateTest2() {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        return matrix;
    }

    public static void main(String[] args) {
        LC0048RotateImage lc0048 = new LC0048RotateImage();
        Solution solution = lc0048.new Solution();
        solution.rotate(lc0048.generateTest1());
        System.out.println("==============================");
        solution.rotate(lc0048.generateTest2());
    }
}
