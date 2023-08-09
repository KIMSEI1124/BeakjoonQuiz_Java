package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형_방 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final int[] dy = {-1, 0, 0, 1};
    private static final int[] dx = {0, -1, 1, 0};
    private static StringTokenizer st;
    private static int t;
    private static int n;
    private static int[][] grid;
    private static int[] dp;
    private static int minNumberIndex;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            answer.append("#").append(i).append(" ").append(minNumberIndex).append(" ").append(dp[minNumberIndex]).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        dp = new int[n * n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        minNumberIndex = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                dfs(1, y, x, grid[y][x]);
            }
        }
        getMinNumberIndex();
    }

    private static void dfs(int depth, int y, int x, int number) {
        int tempNumber = grid[y][x];

        dp[number] = depth;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (canContinue(newY, newX, tempNumber + 1)) {
                continue;
            }
            if (visitedNextNumber(tempNumber + 1)) {
                dp[number] = depth + dp[tempNumber + 1];
                return;
            }
            dfs(depth + 1, newY, newX, number);
        }
    }

    private static boolean canContinue(int y, int x, int nextNumber) {
        return y < 0 || y >= n || x < 0 || x >= n || grid[y][x] != nextNumber;
    }

    private static boolean visitedNextNumber(int nextNumber) {
        return dp[nextNumber] != 0;
    }

    private static void getMinNumberIndex() {
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > dp[minNumberIndex]) {
                minNumberIndex = i;
            }
        }
    }
}
