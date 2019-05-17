package solution;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @ClassName Q48
 * @Description
 * @Author zhihui
 * @Date 2019/5/17 10:50
 * @Version 1.0
 */
public class Q48 {
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        for (int[] matrix1 : matrix) {
            Arrays.stream(matrix1).mapToObj(i -> i + "\t").forEach(System.out::print);
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len <= 1) return;
        int mid = len / 2;
        int remainder = len % 2;
        for (int i = 1; mid - i >= 0; i++) {
            int s = mid - i;
            int e = mid + i - (1 - remainder);
            for (int j = 0; s + j < e; j++) {
                int temp = matrix[s][s + j];
                matrix[s][s + j] = matrix[len - s - j - 1][s];
                int holder = matrix[s + j][len - s - 1];
                matrix[s + j][len - s - 1] = temp;
                temp = holder;
                holder = matrix[len - s - 1][len - s - j - 1];
                matrix[len - s - 1][len - s - j - 1] = temp;
                temp = holder;
                matrix[len - s - j - 1][s] = temp;
            }
        }
    }

}
