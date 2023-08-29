import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1149 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;

    private static int n;
    private static int[][] array;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        array = new int[n + 1][3];
        dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                search(i, j);
            }
        }

        answer = getMinValue();
    }

    private static void search(int i, int j) {
        dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + array[i][j];
    }

    private static int getMinValue() {
        return Arrays.stream(dp[n]).min().getAsInt();
    }
}
