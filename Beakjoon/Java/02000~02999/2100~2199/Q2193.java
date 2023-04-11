import java.io.*;
import java.util.*;

public class Q2193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static long[][] DP;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        DP = new long[N + 1][2];

        // solve
        /*
         * 이친수는 0으로 시작하지 않는다.
         * 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
         */
        DP[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 2; j++) {
                DP[i][0] += DP[i - 1][j]; // 0이 오든 1이 오든 추가
                if (j == 0) { // 0이 올때
                    DP[i][1] += DP[i - 1][j];
                } // 1은 연속으로 올수 없다.
            }
        }

        // output
        System.out.println(DP[N][0] + DP[N][1]);
    }
}