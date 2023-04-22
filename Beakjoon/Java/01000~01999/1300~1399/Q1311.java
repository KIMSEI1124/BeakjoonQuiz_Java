import java.io.*;
import java.util.*;

public class Q1311 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static int dfs(int x, int visited) {
        return dp[x][visited];
    }
}