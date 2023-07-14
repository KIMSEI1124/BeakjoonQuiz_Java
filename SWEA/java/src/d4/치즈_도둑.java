package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 치즈_도둑 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final int EAT = -1;
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            answer.append("#").append(testCase).append(" ").append(getResult()).append("\n");
        }

        System.out.println(answer);
    }

    private static int getResult() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] array = inputArray(n);

        int maxDay = maxDay(array);
        int max = 0;

        for (int day = 0; day <= maxDay; day++) {
            eat(array, day);
            max = Math.max(max, getCount(array));
        }

        return max;
    }

    private static int[][] inputArray(int n) throws IOException {
        int[][] array = new int[n][];
        for (int i = 0; i < n; i++) {
            array[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return array;
    }

    private static int maxDay(int[][] array) {
        int length = array.length;
        int max = 0;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {
                max = Math.max(max, array[y][x]);
            }
        }
        return max;
    }

    private static void eat(int[][] array, int day) {
        int length = array.length;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {
                if (array[y][x] == day) {
                    array[y][x] = EAT;
                }
            }
        }
    }

    private static int getCount(int[][] array) {
        int count = 0;
        int length = array.length;
        boolean[][] visited = new boolean[length][length];

        for (int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {
                if (!visited[y][x] && array[y][x] != EAT) {
                    count++;
                    dfs(array, visited, y, x);
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] array, boolean[][] visited, int y, int x) {
        if (visited[y][x]) {
            return;
        }

        int length = array.length;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newY < 0 || newY >= length || newX < 0 || newX >= length || array[newY][newX] == EAT) {
                continue;
            }
            dfs(array, visited, newY, newX);
        }
    }
}
