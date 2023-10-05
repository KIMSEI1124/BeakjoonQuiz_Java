import java.io.*;
import java.util.*;

public class Q4485 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static int N;
    private static int[][] area;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            input();
            solve(i);
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        area = new int[N + 1][N + 1];
        result = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                area[r][c] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(result[r], 1, N + 1, Integer.MAX_VALUE);
        }
    }

    private static int[] dy = { 1, 0, 0, -1 };
    private static int[] dx = { 0, -1, 1, 0 };

    private static void solve(int problem) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(1, 1));
        result[1][1] = area[1][1];

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newY = pos.y + dy[i];
                int newX = pos.x + dx[i];

                if (newY < 1 || newY > N || newX < 1 || newX > N) {
                    continue;
                }

                Pos newPos = new Pos(newY, newX);
                int cost = area[newY][newX] + result[pos.y][pos.x];
                if (cost < result[newY][newX]) {
                    result[newY][newX] = cost;
                    queue.offer(newPos);
                }
            }
        }

        answer.append("Problem ").append(problem).append(": ").append(result[N][N]).append("\n");
    }

    private static class Pos {
        int y;
        int x;

        public Pos(int r, int c) {
            y = r;
            x = c;
        }
    }
}