import java.io.*;
import java.util.*;

public class Q14501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] T, P;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        int[] DP = new int[N + 2];
        // DP[0] = 0;
        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) {
                DP[i] = DP[i + 1];
            } else {
                // 오늘 기준 = 내일 많이범 or 오늘 일하고 다음일하면 더 많이범
                DP[i] = Math.max(DP[i + 1], DP[i + T[i]] + P[i]);
            }
        }
        // output
        System.out.println(DP[1]);
    }
}