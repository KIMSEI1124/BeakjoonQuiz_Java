package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 저수지의_물의_총_깊이_구하기 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final char WATER = 'W';
    private static final int MAX_DEPTH = 8;
    private static final int MIN_DEPTH = 1;
    private static final int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static final int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            answer.append("#").append(i).append(" ").append(getResult()).append("\n");
        }
        System.out.println(answer);
    }

    private static int getResult() throws IOException {
        int result = 0;
        int n = Integer.parseInt(br.readLine());

        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().replace(" ", "").toCharArray();
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                result = Math.max(result, getDepth(grid, y, x));
                if (result == MAX_DEPTH) {
                    break;
                }
            }
        }

        return result;
    }

    private static int getDepth(char[][] grid, int y, int x) {
        int depth = 0;

        for (int i = 0; i < 8; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newY < 0 || newY >= grid.length || newX < 0 || newX >= grid.length || grid[newY][newX] != WATER) {
                continue;
            }
            depth++;
        }

        if (depth == 0) {
            return MIN_DEPTH;
        }

        return depth;
    }
}
