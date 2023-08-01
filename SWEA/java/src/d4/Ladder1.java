package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final int VISITED = -1;
    private static final int LADDER = 1;
    private static final int START = 2;
    private static int[] startPos;

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 10; i++) {
            String testCase = br.readLine();
            answer.append("#").append(testCase).append(" ")
                    .append(getStartPos(inputGrid())).append("\n");
        }
        System.out.println(answer);
    }

    private static int[][] inputGrid() throws IOException {
        int[][] grid = new int[100][100];
        for (int y = 0; y < 100; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 100; x++) {
                grid[y][x] = Integer.parseInt(st.nextToken());
                if (grid[y][x] == START) {
                    startPos = new int[]{y, x};
                }
            }
        }
        return grid;
    }

    private static int getStartPos(int[][] grid) {
        int y = startPos[0];
        int x = startPos[1];
        while (y != 0) {
            grid[y][x] = VISITED;
            if (canTurnLeft(grid, y, x)) {
                x--;
            } else if (canTurnRight(grid, y, x)) {
                x++;
            } else {
                y--;
            }
        }
        return x;
    }

    private static boolean canTurnRight(int[][] grid, int y, int x) {
        int newX = x + 1;
        return newX < 100 && grid[y][newX] == LADDER;
    }

    private static boolean canTurnLeft(int[][] grid, int y, int x) {
        int newX = x - 1;
        return newX >= 0 && grid[y][newX] == LADDER;
    }
}
