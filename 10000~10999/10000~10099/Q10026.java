import java.io.*;
import java.util.*;

public class Q10026 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        char[][] grid = getGrid(N);
        answer.append(normal(grid) + " " + redGreenMedicine(grid));
        System.out.println(answer);
    }

    private static char[][] getGrid(int N) throws IOException {
        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        return grid;
    }

    private static final int[] dy = { -1, 0, 0, 1 };
    private static final int[] dx = { 0, -1, 1, 0 };

    private static int normal(char[][] grid) {
        int size = grid.length;
        int count = 0;
        boolean[][] visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    count++;
                    Deque<List<Integer>> pos = new ArrayDeque<>();
                    pos.add(List.of(i, j));
                    while (!pos.isEmpty()) {
                        int y = pos.peek().get(0);
                        int x = pos.poll().get(1);
                        char color = grid[y][x];
                        visited[y][x] = true;
                        for (int k = 0; k < 4; k++) {
                            int newY = y + dy[k];
                            int newX = x + dx[k];
                            if (0 > newY || newY >= size) {
                                continue;
                            }
                            if (0 > newX || newX >= size) {
                                continue;
                            }
                            if (visited[newY][newX]) {
                                continue;
                            }
                            if (grid[newY][newX] == color) {
                                pos.add(List.of(newY, newX));
                                visited[newY][newX] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static int redGreenMedicine(char[][] grid) {
        int size = grid.length;
        int count = 0;
        boolean[][] visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    count++;
                    Deque<List<Integer>> pos = new ArrayDeque<>();
                    pos.add(List.of(i, j));
                    while (!pos.isEmpty()) {
                        int y = pos.peek().get(0);
                        int x = pos.poll().get(1);
                        char color = grid[y][x];
                        if (color == 'G') {
                            color = 'R';
                        }
                        visited[y][x] = true;
                        for (int k = 0; k < 4; k++) {
                            int newY = y + dy[k];
                            int newX = x + dx[k];
                            if (0 > newY || newY >= size) {
                                continue;
                            }
                            if (0 > newX || newX >= size) {
                                continue;
                            }
                            if (visited[newY][newX]) {
                                continue;
                            }
                            char gridColor = grid[newY][newX];
                            if (gridColor == 'G') {
                                gridColor = 'R';
                            }
                            if (gridColor == color) {
                                pos.add(List.of(newY, newX));
                                visited[newY][newX] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}