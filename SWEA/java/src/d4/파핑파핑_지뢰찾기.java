package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파핑파핑_지뢰찾기 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final char IS_SAFETY = '.';
    private static final char IS_MINE = '*';
    private static final int[] dx8 = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static final int[] dy8 = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int result = getResult();
            answer.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static int getResult() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int result = 0;
        boolean[][] visited = new boolean[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (arr[y][x] != IS_SAFETY || visited[y][x]) {
                    continue;
                }
                visit(visited, arr, y, x, 0);
                result++;
            }
        }

        return result;
    }

    /* TODO: 2023/07/03 백 트래킹 넣기 */
    private static int visit(boolean[][] visited, char[][] arr, int y, int x, int result) {
        if (visited[y][x]) {
            return result;
        }

        visited[y][x] = true;

        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newY = y + dy8[i];
            int newX = x + dx8[i];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr.length || arr[newY][newX] != IS_MINE) {
                /* 배열 예외 처리 및 지뢰가 아니면 넘기기 */
                continue;
            }
            count++;
        }
        if (count != 0) {
            arr[y][x] = (char) count;
            return result;
        }

        int visitResult = 0;
        for (int i = 0; i < 8; i++) {
            int newY = y + dy8[i];
            int newX = x + dx8[i];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr.length || visited[newY][newX] || arr[newY][newX] != IS_SAFETY) {
                /* 배열 예외 처리 및 이미 방문한 점이거나 안전한 지점이 아니면 넘기기*/
                continue;
            }
            visitResult = visit(visited, arr, newY, newX, result + 1);
        }
        return visitResult;
    }
}
