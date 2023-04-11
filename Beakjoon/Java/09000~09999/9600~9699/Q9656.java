import java.io.*;

public class Q9656 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] dp = new String[1000];
        dp[0] = "CY";
        dp[1] = "SK";
        for (int i = 2; i < N; i++) {
            dp[i] = dp[i % 2];
        }
        System.out.println(dp[N - 1]);
    }
}