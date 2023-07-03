package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 스도쿠_검증 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int result = getResult();
            answer.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static int getResult() throws IOException {
        int[][] area = new int[9][];
        for (int i = 0; i < area.length; i++) {
            area[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        if (isNotValidCol(area) || isNotValidRow(area) || isNotValidBox(area)) {
            return 0;
        }

        return 1;
    }

    private static boolean isNotValidRow(int[][] area) {
        for (int[] row : area) {
            boolean[] visited = new boolean[10];
            for (int number : row) {
                if (visited[number]) {
                    return true;
                }
                visited[number] = true;
            }
        }
        return false;
    }

    private static boolean isNotValidCol(int[][] area) {
        for (int x = 0; x < area.length; x++) {
            boolean[] visited = new boolean[10];
            for (int y = 0; y < area[x].length; y++) {
                int number = area[y][x];
                if (visited[number]) {
                    return true;
                }
                visited[number] = true;
            }
        }
        return false;
    }

    private static boolean isNotValidBox(int[][] area) {
        for (int y = 0; y < area.length; y += 3) {
            for (int x = 0; x < area[y].length; x += 3) {
                boolean[] visited = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int number = area[y + i][x + j];
                        if (visited[number]) {
                            return true;
                        }
                        visited[number] = true;
                    }
                }
            }
        }
        return false;
    }
}
