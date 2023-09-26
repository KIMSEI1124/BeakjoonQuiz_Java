import java.io.*;
import java.util.*;

public class Q14430 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int n;
    private static int m;
    private static int[][] grid;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int[] dy = { 0, 1 };
    private static int[] dx = { 1, 0 };

    private static void solve() {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(0, 0));

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            for (int i = 0; i < 2; i++) {
                int newY = pos.y + dy[i];
                int newX = pos.x + dx[i];

                if (newY < 0 || newY >= n || newX < 0 || newX >= m) {
                    continue;
                }
                int quantity = dp[pos.y][pos.x] + (grid[newY][newX] == 1 ? 1 : 0);
                if (dp[newY][newX] >= quantity) {
                    continue;
                }
                dp[newY][newX] = quantity;
                queue.offer(new Pos(newY, newX));
            }
        }

        answer.append(dp[n - 1][m - 1]);
    }

    private static class Pos {
        final int y;
        final int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}