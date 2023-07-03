package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 파리_퇴치3 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final int[] xPlus = {0, 1, 0, -1};
    private static final int[] yPlus = {-1, 0, 1, 0};
    private static final int[] xCross = {-1, 1, 1, -1};
    private static final int[] yCross = {-1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int max = 0;

            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray(); /* 0 : N, 1 : M */

            int[][] arr = new int[data[0]][];
            for (int i = 0; i < data[0]; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            for (int y = 0; y < data[0]; y++) {
                for (int x = 0; x < data[0]; x++) {
                    max = Math.max(max, getResult(arr, data[1], y, x));
                }
            }

            answer.append("#").append(testCase).append(" ").append(max).append("\n");
        }

        System.out.println(answer);
    }

    private static int getResult(int[][] arr, int m, int y, int x) {
        int length = arr.length;
        int plus = arr[y][x];
        int cross = arr[y][x];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                int newY = y + yPlus[j] * i;
                int newX = x + xPlus[j] * i;
                if (newX < 0 || newX >= length || newY < 0 || newY >= length) {
                    continue;
                }
                plus += arr[newY][newX];
            }
            for (int j = 0; j < 4; j++) {
                int newY = y + yCross[j] * i;
                int newX = x + xCross[j] * i;
                if (newX < 0 || newX >= length || newY < 0 || newY >= length) {
                    continue;
                }
                cross += arr[newY][newX];
            }
        }

        return Math.max(plus, cross);
    }
}
