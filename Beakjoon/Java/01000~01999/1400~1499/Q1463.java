import java.io.*;

public class Q1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, min;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 10^6
        dp(N);
    }

    static public void solve1(int N) throws IOException { // 최적화 X
        int count = 0;
        while (1 < N) {
            if ((N - 1) % 3 == 0 || (N - 1) % 3 == 0) {
                N--;
            } else if (N % 6 == 0) {
                N /= 6;
                count++;
            } else if (N % 3 == 0) {
                N /= 3;
            } else if (N % 2 == 0) {
                N /= 2;
            } else {
                N--;
            }
            count++;
        }
        System.out.println(count);
    }

    static public void solve2(int N) { // 시간 초과
        // input
        int count = 0;
        min = 1000000000;
        // solve
        bfs(N, count);

        // output
        System.out.println(min);
    }

    static public void bfs(int id, int count) {
        if (id == 1) {
            min = Math.min(min, count);
            return;
        }
        count++;
        if (id % 3 == 0) {
            bfs(id / 3, count);
        }
        if (id % 2 == 0) {
            bfs(id / 2, count);
        }
        bfs(id - 1, count);
    }

    static public void dp(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}